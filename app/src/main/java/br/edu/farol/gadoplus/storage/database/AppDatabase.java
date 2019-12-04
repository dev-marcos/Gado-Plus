package br.edu.farol.gadoplus.storage.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import br.edu.farol.gadoplus.model.Animal;
import br.edu.farol.gadoplus.model.Gasto;
import br.edu.farol.gadoplus.model.Lote;
import br.edu.farol.gadoplus.model.Pesagem;
import br.edu.farol.gadoplus.model.PesagemAnimal;
import br.edu.farol.gadoplus.model.Propriedade;
import br.edu.farol.gadoplus.model.Raca;
import br.edu.farol.gadoplus.model.TipoGasto;
import br.edu.farol.gadoplus.storage.database.dao.AnimalDao;
import br.edu.farol.gadoplus.storage.database.dao.GastoDao;
import br.edu.farol.gadoplus.storage.database.dao.LoteDao;
import br.edu.farol.gadoplus.storage.database.dao.PesagemAnimalDao;
import br.edu.farol.gadoplus.storage.database.dao.PesagemDao;
import br.edu.farol.gadoplus.storage.database.dao.PropriedadeDao;
import br.edu.farol.gadoplus.storage.database.dao.RacaDao;
import br.edu.farol.gadoplus.storage.database.dao.TipoGastoDao;
import br.edu.farol.gadoplus.util.Util;


@Database(
        entities = {
                Animal.class,
                Gasto.class,
                Lote.class,
                Pesagem.class,
                PesagemAnimal.class,
                Propriedade.class,
                Raca.class,
                TipoGasto.class
        },
        version = 1,
        exportSchema = false
)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract AnimalDao animalDao();
    public abstract GastoDao gastoDao();
    public abstract LoteDao loteDao();
    public abstract PesagemDao pesagemDao();
    public abstract PesagemAnimalDao pesagemAnimalDao();
    public abstract PropriedadeDao propriedadeDao();
    public abstract RacaDao racaDao();
    public abstract TipoGastoDao tipoGastoDao();


    public static final String DATABSE_NAME = "database.db";

    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null)
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABSE_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .addCallback(roomCallback)
                    .build();
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private PropriedadeDao propriedadeDao;
        private RacaDao racaDao;
        private AnimalDao animalDao;

        private PopulateDbAsyncTask(AppDatabase db) {
            propriedadeDao = db.propriedadeDao();
            animalDao = db.animalDao();
            racaDao = db.racaDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            propriedadeDao.insert(new Propriedade("Title 1", 12,"Description 1"));
            propriedadeDao.insert(new Propriedade("Title 2", 23,"Description 2"));
            propriedadeDao.insert(new Propriedade("Title 3", 45,"Description 3"));

            Animal animal = new Animal();
            animal.setNome("Boi Teste");
            animal.setSexo("Macho");
            animal.setDtEntrada("01/05/2019");
            animal.setDtPrimeiraPesagem("01/05/2019");
            animal.setPrimeiroPeso(78);
            animal.setRacaId(1);
            animal.setPrecoCompra(90);
            animal.setDtNascimento("01/05/2019");
            animal.setDtDesmame("01/05/2019");
            animal.setObservacoes("Nenhuma Observação a declarar");

            animalDao.insert(animal);

            return null;
        }
    }
}

