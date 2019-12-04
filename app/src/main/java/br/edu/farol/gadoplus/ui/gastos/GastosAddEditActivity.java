package br.edu.farol.gadoplus.ui.gastos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import br.edu.farol.gadoplus.R;
import br.edu.farol.gadoplus.model.Animal;
import br.edu.farol.gadoplus.model.TipoGasto;
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

    int idAnimal = 0;
    int idTipoGasto = 0;

    private AnimaisViewModel animaisViewModel;
    private TipoGastosViewModel tipoGastosViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastos_add_edit);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        editTextData = findViewById(R.id.et_gastos_data);
        editTextValor = findViewById(R.id.et_gastos_valor);
        editTextDescricao = findViewById(R.id.et_gastos_descricao);


        spinnerAnimal = findViewById(R.id.spinner_gastos_animal);
        final ArrayAdapter<Animal> adapterAnimalSpinner = new ArrayAdapter<Animal>(this,
                android.R.layout.simple_spinner_item);
        adapterAnimalSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAnimal.setAdapter(adapterAnimalSpinner);
        animaisViewModel = ViewModelProviders.of(this).get(AnimaisViewModel.class);
        animaisViewModel.getAll().observe(this, new Observer<List<Animal>>() {
            @Override
            public void onChanged(@Nullable List<Animal> animals) {
                adapterAnimalSpinner.clear();
                adapterAnimalSpinner.addAll(animals);

            }
        });

        spinnerTipoGasto = findViewById(R.id.spinner_gastos_tipo);
        final ArrayAdapter<TipoGasto> adapterTipoGastoSpinner = new ArrayAdapter<TipoGasto>(this,
                android.R.layout.simple_spinner_item);
        adapterTipoGastoSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoGasto.setAdapter(adapterTipoGastoSpinner);
        tipoGastosViewModel = ViewModelProviders.of(this).get(TipoGastosViewModel.class);
        tipoGastosViewModel.getAll().observe(this, new Observer<List<TipoGasto>>() {
            @Override
            public void onChanged(@Nullable List<TipoGasto> tipoGastos) {
                adapterTipoGastoSpinner.clear();
                adapterTipoGastoSpinner.addAll(tipoGastos);

            }
        });




        Intent intent = getIntent();

        if (intent.hasExtra(EXTRA_ID)) {
            setTitle("Editar");

            editTextData.setText(intent.getStringExtra(EXTRA_DATA));
            editTextValor.setText(String.valueOf(intent.getStringExtra(EXTRA_VALOR)));
            editTextDescricao.setText(intent.getStringExtra(EXTRA_DESCRICAO));

            idAnimal = intent.getIntExtra(EXTRA_ANIMAL_ID, 0);
            idTipoGasto = intent.getIntExtra(EXTRA_TIPO_GASTO_ID, 0);


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

        Animal animal = (Animal) spinnerAnimal.getSelectedItem();
        TipoGasto tipoGasto = (TipoGasto) spinnerTipoGasto.getSelectedItem();

        int animalId = animal.getId();
        int gastoId = tipoGasto.getId();

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
