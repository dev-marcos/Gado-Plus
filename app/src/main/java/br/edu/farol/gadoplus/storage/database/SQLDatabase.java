package br.edu.farol.gadoplus.storage.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import br.edu.farol.gadoplus.model.Propriedade;

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
       // }
    }

    public long insertPropriedade(Propriedade propriedade){
        ContentValues values = new ContentValues();
        long retornoDB;

        values.put(Schema.Propriedade.NOME, propriedade.getNome());
        values.put(Schema.Propriedade.HECTARES, propriedade.getHectares());
        values.put(Schema.Propriedade.DESCRICAO, propriedade.getDescricao());

        retornoDB = getWritableDatabase().insert(Schema.Propriedade.TABLE, null,values);
        return retornoDB;
    }

    public long updatePropriedade(Propriedade propriedade){
        ContentValues values = new ContentValues();
        long retornoDB;

        values.put(Schema.Propriedade.ID, propriedade.getId());
        values.put(Schema.Propriedade.NOME, propriedade.getNome());
        values.put(Schema.Propriedade.HECTARES, propriedade.getHectares());
        values.put(Schema.Propriedade.DESCRICAO, propriedade.getDescricao());


        String[] args = {String.valueOf(propriedade.getId())};

        retornoDB = getWritableDatabase().update(Schema.Propriedade.TABLE, values, Schema.Propriedade.ID+"=?", args);
        return retornoDB;
    }
   /* public ArrayList<Propriedade> getPropriedade(){
        String [] columns = {Schema.Propriedade.ID, Schema.Propriedade.NOME, Schema.Propriedade.HECTARES, Schema.Propriedade.DESCRICAO};

        Cursor cursor = getWritableDatabase().query(Schema.Propriedade.TABLE, columns,Schema.Propriedade.ATIVO + "=?","1",null,null,null,);
        ArrayList<Propriedade> propriedades = new ArrayList<Propriedade>();

        while (cursor.moveToNext()){
            Propriedade propriedade = new Propriedade();
            propriedade.setId(cursor.getInt(0));
            propriedade.setNome(cursor.getString(1));
            propriedade.setHectares(cursor.getDouble(2));
            propriedade.setDescricao(cursor.getString(3));

            propriedades.add(propriedade);
        }
        return propriedades;
    }*/
}
