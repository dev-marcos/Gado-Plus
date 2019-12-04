package br.edu.farol.gadoplus.ui.pesagem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import br.edu.farol.gadoplus.R;


public class PesagemAddEditActivity extends AppCompatActivity {
    public static final String EXTRA_ID="br.edu.farol.gadoplus.ui.lotes.EXTRA_ID";
    public static final String EXTRA_LOTE_ID="br.edu.farol.gadoplus.ui.lotes.EXTRA_LOTE_ID";
    public static final String EXTRA_DATA="br.edu.farol.gadoplus.ui.lotes.EXTRA_DATA";
    public static final String EXTRA_DESCRICAO="br.edu.farol.gadoplus.ui.lotes.EXTRA_DESCRICAO";


    private Spinner  spinnerLote;
    private EditText editTextData;
    private EditText editTextDescricao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesagem_add_edit);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        spinnerLote       = findViewById(R.id.spinner_pesagem_lote);
        editTextData      = findViewById(R.id.et_pesagem_data);
        editTextDescricao = findViewById(R.id.et_pesagem_descricao);


        Intent intent = getIntent();

        if (intent.hasExtra(EXTRA_ID)) {
            setTitle("Editar");
            editTextData.setText(intent.getStringExtra(EXTRA_DATA));
            // spinnerLote.setText(intent.getStringExtra(EXTRA_LOTE_ID));
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

        int loteId = 1;

        String sData = editTextData.getText().toString();
        String descricao =  editTextDescricao.getText().toString();

        if (sData.trim().isEmpty() || descricao.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show();
        }else{

            Intent data = new Intent();

            data.putExtra(EXTRA_LOTE_ID, loteId);
            data.putExtra(EXTRA_DATA, sData);
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
            setResult(PesagemFragment.DELETE_REQUEST, data);
            finish();
        }
    }


}
