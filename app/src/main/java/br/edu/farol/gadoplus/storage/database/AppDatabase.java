package br.edu.farol.gadoplus.storage.database;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.edu.farol.gadoplus.model.Propriedade;
import br.edu.farol.gadoplus.storage.database.dao.PropriedadeDao;


@Database(entities = {Propriedade.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PropriedadeDao propriedadeDao();

    public static final String DATABSE_NAME = "database";

    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null)
            instance = Room.databaseBuilder(context, AppDatabase.class, DATABSE_NAME)
                    .allowMainThreadQueries()
                    .build();
        return instance;
    }
}

