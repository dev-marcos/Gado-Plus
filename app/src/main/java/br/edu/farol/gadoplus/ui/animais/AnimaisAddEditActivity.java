package br.edu.farol.gadoplus.ui.animais;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.farol.gadoplus.R;
import br.edu.farol.gadoplus.adapter.PropriedadeAdapter;
import br.edu.farol.gadoplus.model.Animal;
import br.edu.farol.gadoplus.model.Propriedade;
import br.edu.farol.gadoplus.storage.database.AppDatabase;
import br.edu.farol.gadoplus.storage.database.dao.PropriedadeDao;
import br.edu.farol.gadoplus.ui.propriedade.PropriedadeFragment;
import br.edu.farol.gadoplus.util.Util;


public class AnimaisAddEditActivity extends AppCompatActivity {
    public static final String EXTRA_ID="br.edu.farol.gadoplus.ui.propriedades.EXTRA_ID";
    public static final String EXTRA_NOME="br.edu.farol.gadoplus.ui.propriedades.EXTRA_NOME";
    public static final String EXTRA_LOTE_ID="br.edu.farol.gadoplus.ui.propriedades.EXTRA_LOTE_ID";
    public static final String EXTRA_SEXO="br.edu.farol.gadoplus.ui.propriedades.EXTRA_SEXO";
    public static final String EXTRA_DT_ENTRADA="br.edu.farol.gadoplus.ui.propriedades.EXTRA_DT_ENTRADA";
    public static final String EXTRA_DT_PRIMEIRA_PESAGEM="br.edu.farol.gadoplus.ui.propriedades.EXTRA_DT_PRIMEIRA_PESAGEM";
    public static final String EXTRA_PRIMEIRO_PESO="br.edu.farol.gadoplus.ui.propriedades.EXTRA_PRIMEIRO_PESO";
    public static final String EXTRA_RACA_ID="br.edu.farol.gadoplus.ui.propriedades.EXTRA_RACA_ID";
    public static final String EXTRA_PRECO_COMPRA="br.edu.farol.gadoplus.ui.propriedades.EXTRA_PRECO_COMPRA";
    public static final String EXTRA_DT_NASCIMENTO="br.edu.farol.gadoplus.ui.propriedades.EXTRA_DT_NASCIMENTO";
    public static final String EXTRA_DT_DESMAME="br.edu.farol.gadoplus.ui.propriedades.EXTRA_DT_DESMAME";
    public static final String EXTRA_OBSERVACOES="br.edu.farol.gadoplus.ui.propriedades.EXTRA_OBSERVACOES";


    private EditText editTextNome;
    private EditText editTextHectares;
    private EditText editTextDescricao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animais_add_edit);

        editTextNome = findViewById(R.id.et_propriedade_nome);
        editTextHectares = findViewById(R.id.et_propriedade_hectare);
        editTextDescricao = findViewById(R.id.et_propriedade_descricao);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        Intent intent = getIntent();



        if (intent.hasExtra(EXTRA_ID)) {
            setTitle("Editar");
            editTextNome.setText(intent.getStringExtra(EXTRA_NOME));
            editTextHectares.setText(String.valueOf(intent.getDoubleExtra(EXTRA_LOTE_ID,0)));
            editTextDescricao.setText(intent.getStringExtra(EXTRA_SEXO));
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
                onSavePropriedades();
                return true;
            case R.id.action_item_delete:
                onDeletePropriedades();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    private void onSavePropriedades() {

        //String nome = editTextNome.getText().toString();
        String nome = "";
        int loteId = 1;
        String sexo = "";
        Date dtEntrada = Util.StringToDate("13/01/2019");
        Date dtPrimeiraPesagem = Util.StringToDate("13/01/2019");
        double primeiroPeso = 0;
        int racaId = 1;
        double precoCompra = 0;
        Date dtNascimento = Util.StringToDate("13/01/2019");
        Date dtDesmame  = Util.StringToDate("13/01/2019");
        String observacoes = "";


        //if (!editTextHectares.getText().toString().trim().isEmpty())
          //  hectare = Double.parseDouble(editTextHectares.getText().toString());

        //String descricao = editTextDescricao.getText().toString();


        if (nome.trim().isEmpty() || observacoes.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show();
        }else{
            Intent data = new Intent();


            data.putExtra(EXTRA_NOME, nome);
            data.putExtra(EXTRA_LOTE_ID, loteId);
            data.putExtra(EXTRA_SEXO, sexo);
            data.putExtra(EXTRA_DT_ENTRADA, dtEntrada);
            data.putExtra(EXTRA_DT_PRIMEIRA_PESAGEM, dtPrimeiraPesagem);
            data.putExtra(EXTRA_PRIMEIRO_PESO, primeiroPeso);
            data.putExtra(EXTRA_RACA_ID, racaId);
            data.putExtra(EXTRA_PRECO_COMPRA, precoCompra);
            data.putExtra(EXTRA_DT_NASCIMENTO, dtNascimento);
            data.putExtra(EXTRA_DT_DESMAME, dtDesmame);
            data.putExtra(EXTRA_OBSERVACOES, observacoes);


            int id = getIntent().getIntExtra(EXTRA_ID, -1);
            if (id != -1) {
                data.putExtra(EXTRA_ID, id);
            }

            setResult(RESULT_OK, data);
            finish();
        }
    }

    private void onDeletePropriedades() {
        Intent data = new Intent();
        int id = getIntent().getIntExtra(EXTRA_ID, -1);

        if (id != -1) {
            data.putExtra(EXTRA_ID, id);
            setResult(PropriedadeFragment.DELETE_REQUEST, data);
            finish();
        }
    }
}