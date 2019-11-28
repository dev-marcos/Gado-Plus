package br.edu.farol.gadoplus.ui.pesagem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.edu.farol.gadoplus.R;


public class PesagemAddEditActivity extends AppCompatActivity {

    EditText pesagemData;
    Spinner spinnerLote;

    Calendar calendario;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesagem_add_edit);
        setTitle("Cadastrar Pesagem");

        pesagemData = findViewById(R.id.et_pesagem_data);
        spinnerLote = findViewById(R.id.spinner_pesagem_lote);

        List<String> list = new ArrayList<String>();

        list.add("Lote 1");
        list.add("Lote 2");
        list.add("Lote 3");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLote.setAdapter(dataAdapter);



        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

        pesagemData.setText(formatador.format(data));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
