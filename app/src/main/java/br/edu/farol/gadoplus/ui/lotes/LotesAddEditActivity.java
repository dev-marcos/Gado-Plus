package br.edu.farol.gadoplus.ui.lotes;

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

import java.util.ArrayList;
import java.util.List;

import br.edu.farol.gadoplus.R;
import br.edu.farol.gadoplus.ui.animais.AnimaisFragment;


public class LotesAddEditActivity extends AppCompatActivity {
    public static final String EXTRA_ID="br.edu.farol.gadoplus.ui.lotes.EXTRA_ID";
    public static final String EXTRA_NOME="br.edu.farol.gadoplus.ui.lotes.EXTRA_NOME";
    public static final String EXTRA_PROPRIEDADE_ID="br.edu.farol.gadoplus.ui.lotes.EXTRA_PROPRIEDADE_ID";
    public static final String EXTRA_DESCRICAO="br.edu.farol.gadoplus.ui.lotes.EXTRA_DESCRICAO";


    private EditText editTextNome;
    private Spinner  spinnerPropriedade;
    private EditText editTextDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lotes_add_edit);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        editTextNome       = findViewById(R.id.et_lote_nome);
        spinnerPropriedade = findViewById(R.id.spinner_lote_propriedade);
        editTextDescricao  = findViewById(R.id.et_lote_descricao);


        Intent intent = getIntent();

        if (intent.hasExtra(EXTRA_ID)) {
            setTitle("Editar");
            editTextNome.setText(intent.getStringExtra(EXTRA_NOME));
           // spinnerPropriedade.setText(intent.getStringExtra(EXTRA_PROPRIEDADE_ID));
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

        int propriedadeId = 1;

        String nome = editTextNome.getText().toString();
        String descricao =  editTextDescricao.getText().toString();


        if (nome.trim().isEmpty() || descricao.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show();
        }else{

            Intent data = new Intent();

            data.putExtra(EXTRA_NOME, nome);
            data.putExtra(EXTRA_PROPRIEDADE_ID, propriedadeId);
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
            setResult(AnimaisFragment.DELETE_REQUEST, data);
            finish();
        }
    }


}
