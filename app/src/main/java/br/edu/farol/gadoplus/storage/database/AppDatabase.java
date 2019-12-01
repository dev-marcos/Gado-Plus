package br.edu.farol.gadoplus.storage.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import br.edu.farol.gadoplus.model.Propriedade;
import br.edu.farol.gadoplus.storage.database.dao.PropriedadeDao;


@Database(entities = {Propriedade.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PropriedadeDao propriedadeDao();


    public static final String DATABSE_NAME = "database";

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null)
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, DATABSE_NAME)
                    .allowMainThreadQueries()
                    .addCallback(sRoomDatabaseCallback)
                    .build();
        return INSTANCE;
    }

    /**
     * Override the onOpen method to populate the database.
     * For this sample, we clear the database every time it is created or opened.
     */
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){

        @Override
        public void onOpen (@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            // If you want to keep the data through app restarts,
            // comment out the following line.
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    /**
     * Populate the database in the background.
     * If you want to start with more words, just add them.
     */
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final PropriedadeDao pDao;

        PopulateDbAsync(AppDatabase db) {
            pDao = db.propriedadeDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            pDao.deleteAll();

            Propriedade propriedade = new Propriedade();
            propriedade.setNome("Nome Teste");
            propriedade.setDescricao("Descrição Teste");
            propriedade.setHectares(123.00);



            pDao.insert(propriedade);
            return null;
        }
    }
}

