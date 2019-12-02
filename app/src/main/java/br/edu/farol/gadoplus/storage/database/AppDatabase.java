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
        version = 1
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

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null)
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, DATABSE_NAME)
                    .allowMainThreadQueries()
                    .build();
        return INSTANCE;
    }
}

