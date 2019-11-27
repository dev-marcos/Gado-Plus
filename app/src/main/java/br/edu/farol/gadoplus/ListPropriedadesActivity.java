package br.edu.farol.gadoplus;

import android.content.Context;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


import android.view.View;



import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.edu.farol.gadoplus.model.Propriedade;
import br.edu.farol.gadoplus.storage.database.AppDatabase;
import br.edu.farol.gadoplus.storage.database.dao.PropriedadeDao;
import br.edu.farol.gadoplus.ui.propriedades.PropriedadesAddEditActivity;

import static br.edu.farol.gadoplus.MainActivity.APP_PREFERENCES;

public class ListPropriedadesActivity extends AppCompatActivity {



    private RecyclerView recyclerView;
    private ArrayList<Propriedade> propriedades;

    private PropriedadeDao dao;

    private FloatingActionButton fab;
    private SharedPreferences settings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        settings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list_propriedades);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

       // setupNavigation(savedInstanceState, toolbar);
        // init recyclerView
      //  recyclerView = findViewById(R.id.propriedade_list);
      //  recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // init fab Button
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onAddNewPropriedade();
            }
        });


        dao = AppDatabase.getInstance(this).propriedadeDao();
    }



    private void loadPropriedade() {
        this.propriedades = new ArrayList<>();
        List<Propriedade> list = dao.getAll();// get All notes from DataBase
        this.propriedades.addAll(list);

    }



    private void onAddNewPropriedade() {
        startActivity(new Intent(this, PropriedadesAddEditActivity.class));

    }


    @Override
    protected void onResume() {
        super.onResume();
        loadPropriedade();
    }
/*
    @Override
    public void onPropriedadeClick(Propriedade propriedade) {
        // TODO: 22/07/2018  note clicked : edit note
        Intent edit = new Intent(this, PropriedadesAddEditActivity.class);
        edit.putExtra("id", propriedade.getId());
        startActivity(edit);

    }
*/
}



