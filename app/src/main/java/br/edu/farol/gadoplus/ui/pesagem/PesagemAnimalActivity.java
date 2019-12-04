package br.edu.farol.gadoplus.ui.pesagem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import javax.annotation.Nullable;

import br.edu.farol.gadoplus.R;
import br.edu.farol.gadoplus.adapter.PesagemAnimalAdapter;
import br.edu.farol.gadoplus.model.PesagemAnimal;

public class PesagemAnimalActivity extends AppCompatActivity {

    private PesagemAnimalViewModel pesagemAnimalViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesagem_animal);

        pesagemAnimalViewModel = ViewModelProviders.of(this).get(PesagemAnimalViewModel.class);

        final RecyclerView recyclerView = findViewById(R.id.rv_pesagem_animal);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);

        final PesagemAnimalAdapter adapter = new PesagemAnimalAdapter();
        recyclerView.setAdapter(adapter);


        pesagemAnimalViewModel.getAll().observe(this, new Observer<List<PesagemAnimal>>() {
            @Override
            public void onChanged(@Nullable List<PesagemAnimal> pesagemAnimals) {
                adapter.setPesagemAnimal(pesagemAnimals);
            }
        });

        adapter.setOnClickListener(new PesagemAnimalAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(PesagemAnimal pesagemAnimal) {
                onDelete(pesagemAnimal);
            }
        });
    }

    public void onSave(PesagemAnimal pesagemAnimal){
        pesagemAnimalViewModel.insert(pesagemAnimal);
    }

    private void onDelete(PesagemAnimal pesagemAnimal) {
        pesagemAnimalViewModel.delete(pesagemAnimal);
    }
}
