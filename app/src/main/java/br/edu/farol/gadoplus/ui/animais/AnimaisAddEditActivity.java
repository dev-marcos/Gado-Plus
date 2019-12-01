package br.edu.farol.gadoplus.ui.animais;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import br.edu.farol.gadoplus.R;
import br.edu.farol.gadoplus.adapter.PropriedadeAdapter;
import br.edu.farol.gadoplus.model.Propriedade;


public class AnimaisAddEditActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animais_add_edit);

          RecyclerView recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        Propriedade p = new Propriedade();
        p.setNome("Teste");
        p.setDescricao("ok");
        p.setHectares(12);
        p.setId(1);

        Propriedade p1 = new Propriedade();
        p1.setNome("Fazenda Feliz");
        p1.setDescricao("Esta é uma linda Fazenda");
        p1.setHectares(30);
        p1.setId(2);

        List<Propriedade> propriedades = new ArrayList<>();
        propriedades.add(p);
        propriedades.add(p1);


        PropriedadeAdapter adapter = new PropriedadeAdapter(propriedades);
        recyclerView.setAdapter(adapter);
    }

}
