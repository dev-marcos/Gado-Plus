package br.edu.farol.gadoplus.ui.propriedades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.farol.gadoplus.R;
import br.edu.farol.gadoplus.model.Propriedade;
import br.edu.farol.gadoplus.storage.database.AppDatabase;
import br.edu.farol.gadoplus.storage.database.dao.PropriedadeDao;

public class PropriedadesAddEditActivity extends AppCompatActivity {
    private EditText inputNome;
    private EditText inputHectares;
    private EditText inputDescricao;


    private PropriedadeDao dao;
    private Propriedade temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propriedades_add_edit);
        //Toolbar toolbar = findViewById(R.id.edit_propriedade_toolbar);
        //setSupportActionBar(toolbar);

        inputNome = findViewById(R.id.input_propriedade_nome);
        inputHectares = findViewById(R.id.input_propriedade_hectare);
        inputDescricao = findViewById(R.id.input_propriedade_descricao);

        dao = AppDatabase.getInstance(this).propriedadeDao();
        if(getIntent().getExtras()!= null){
            int id = getIntent().getExtras().getInt("id",0);
            temp = dao.getById(id);
            inputNome.setText(temp.getNome());
            inputHectares.setText(String.valueOf(temp.getHectares()));
            inputDescricao.setText(temp.getDescricao());

        }else inputNome.setFocusable(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_item_edit_save)
            onSavePropriedades();

        if (id == R.id.action_item_delete)
            onDeletePropriedades();

        return super.onOptionsItemSelected(item);
    }

    private void onSavePropriedades() {
     /*   String nome = inputNome.getText().toString();
        double hectare = new Double(inputHectares.getText().toString());
        String descricao = inputDescricao.getText().toString();
        if (!nome.isEmpty()) {
            // se não exite cria um novo
            if (temp == null) {
                temp = new Propriedade();
                temp.setDescricao(nome);
                temp.setHectares(hectare);
                temp.setDescricao(descricao);
                dao.insert(temp);*/
                Toast.makeText(getApplicationContext(), "Registro inserido!", Toast.LENGTH_SHORT).show();
         /*   } else {
                temp.setDescricao(nome);
                temp.setHectares(hectare);
                temp.setDescricao(descricao);
                dao.update(temp);
                Toast.makeText(getApplicationContext(), "Registro alterado!", Toast.LENGTH_SHORT).show();
            }

*/

            finish(); // retorna para Activity Principal
    //    }

    }

    private void onDeletePropriedades() {
        Toast.makeText(getApplicationContext(), "Deletado com sucesso!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
