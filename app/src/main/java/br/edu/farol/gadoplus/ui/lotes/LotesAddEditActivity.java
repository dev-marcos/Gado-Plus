package br.edu.farol.gadoplus.ui.lotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import br.edu.farol.gadoplus.R;


public class LotesAddEditActivity extends AppCompatActivity {

    Spinner spinnerPropriedade;
    Menu mMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lotes_add_edit);
        setTitle("Cadastrar Lote");


        spinnerPropriedade = findViewById(R.id.spinner_lote_propriedade);



        List<String> list = new ArrayList<String>();

        list.add("Fazenda Fogaça");
        list.add("A Fazenda");
        list.add("Fazenda World");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPropriedade.setAdapter(dataAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return super.onCreateOptionsMenu(menu);
    }


}
