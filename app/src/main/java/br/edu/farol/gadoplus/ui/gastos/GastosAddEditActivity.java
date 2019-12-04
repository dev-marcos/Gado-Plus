package br.edu.farol.gadoplus.ui.gastos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.common.collect.Multiset;

import java.util.ArrayList;
import java.util.List;

import br.edu.farol.gadoplus.R;
import br.edu.farol.gadoplus.model.Animal;
import br.edu.farol.gadoplus.ui.animais.AnimaisViewModel;

public class GastosAddEditActivity extends AppCompatActivity {
    public static final String EXTRA_ID="br.edu.farol.gadoplus.ui.gastos.EXTRA_ID";
    public static final String EXTRA_TIPO_GASTO_ID="br.edu.farol.gadoplus.ui.gastos.EXTRA_TIPO_GASTO_ID";
    public static final String EXTRA_ANIMAL_ID="br.edu.farol.gadoplus.ui.gastos.EXTRA_ANIMAL_ID";
    public static final String EXTRA_DATA="br.edu.farol.gadoplus.ui.gastos.EXTRA_DATA";
    public static final String EXTRA_VALOR="br.edu.farol.gadoplus.ui.gastos.EXTRA_VALOR";
    public static final String EXTRA_DESCRICAO="br.edu.farol.gadoplus.ui.gastos.EXTRA_DESCRICAO";


    private Spinner  spinnerTipoGasto;
    private Spinner  spinnerAnimal;
    private EditText editTextData;
    private EditText editTextValor;
    private EditText editTextDescricao;

    private AnimaisViewModel animaisViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastos_add_edit);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);


        spinnerTipoGasto = findViewById(R.id.spinner_gastos_tipo);
        spinnerAnimal = findViewById(R.id.spinner_gastos_animal);
        editTextData = findViewById(R.id.et_gastos_data);
        editTextValor = findViewById(R.id.et_gastos_valor);
        editTextDescricao = findViewById(R.id.et_gastos_descricao);


        Intent intent = getIntent();

        if (intent.hasExtra(EXTRA_ID)) {
            setTitle("Editar");

           //spinnerTipoGasto.setText(intent.getStringExtra(EXTRA_TIPO_GASTO_ID));
            //spinnerAnimal.setText(intent.getStringExtra(EXTRA_ANIMAL_ID));
            editTextData.setText(intent.getStringExtra(EXTRA_DATA));
            editTextValor.setText(intent.getStringExtra(EXTRA_VALOR));
            editTextDescricao.setText(intent.getStringExtra(EXTRA_DESCRICAO));

        } else {
            setTitle("Cadastar");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_edit, menu);
        MenuItem itemDelete = menu.findItem(R.id.action_item_delete);
        itemDelete.setVisible(getIntent().hasExtra(EXTRA_ID));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_item_edit_save:
                onSave();
                return true;
            case R.id.action_item_delete:
                onDelete();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void onSave() {

        int gastoId = 1;
        int animalId = 1;

        String sData = editTextData.getText().toString();
        double valor = editTextValor.getText().toString().trim().isEmpty()? 0: Double.parseDouble(editTextValor.getText().toString());
        String descricao = editTextDescricao.getText().toString();


        if (!(gastoId > 0) || sData.trim().isEmpty()|| !(valor > 0) || descricao.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show();
        }else{

            Intent data = new Intent();

            data.putExtra(EXTRA_TIPO_GASTO_ID, gastoId);
            data.putExtra(EXTRA_ANIMAL_ID, animalId);
            data.putExtra(EXTRA_DATA, sData);
            data.putExtra(EXTRA_VALOR, valor);
            data.putExtra(EXTRA_DESCRICAO, descricao);

            int id = getIntent().getIntExtra(EXTRA_ID, -1);
            if (id != -1) {
                data.putExtra(EXTRA_ID, id);
            }

            setResult(RESULT_OK, data);
            finish();
        }
    }

    private void onDelete() {
        Intent data = new Intent();
        int id = getIntent().getIntExtra(EXTRA_ID, -1);

        if (id != -1) {
            data.putExtra(EXTRA_ID, id);
            setResult(GastosFragment.DELETE_REQUEST, data);
            finish();
        }
    }

}
