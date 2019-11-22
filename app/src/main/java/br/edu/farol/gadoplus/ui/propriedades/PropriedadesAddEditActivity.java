package br.edu.farol.gadoplus.ui.propriedades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import br.edu.farol.gadoplus.R;
import br.edu.farol.gadoplus.model.Propriedade;

public class PropriedadesAddEditActivity extends AppCompatActivity {
    private EditText inputNome;
    private EditText inputHectares;
    private EditText inputDescricao;

    private Propriedade temp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        theme = settings.getInt(THEME_Key, R.style.AppTheme);
        setTheme(theme);



    }
}
