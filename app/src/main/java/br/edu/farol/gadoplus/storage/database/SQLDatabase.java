package br.edu.farol.gadoplus.storage.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLDatabase extends SQLiteOpenHelper {

    private static  final String DATABASE = "database.db";
    private static  final int VERSION = 1;

    public SQLDatabase(Context context){
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Schema.CREATE_TABLE_PROPRIEDADE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
       // if (i < 2) {

         //   db.execSQL(Schema.CREATE_WALLET_INDEX_COLUMN);
         //  db.execSQL(Schema.CREATE_CATEGORY_INDEX_COLUMN);
       // }

    }
}
