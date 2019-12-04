package br.edu.farol.gadoplus.ui.animais;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import br.edu.farol.gadoplus.R;
import br.edu.farol.gadoplus.adapter.AnimalAdapter;
import br.edu.farol.gadoplus.model.Animal;

public class AnimaisSearchActivity extends AppCompatActivity {
    public static final String EXTRA_ID="br.edu.farol.gadoplus.ui.animais.EXTRA_ID";

    private AnimaisViewModel animaisViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animais_search);


        final RecyclerView recyclerView = findViewById(R.id.rv_animais);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);

        final AnimalAdapter adapter = new AnimalAdapter();
        recyclerView.setAdapter(adapter);

        animaisViewModel.getAll().observe(this, new Observer<List<Animal>>() {
            @Override
            public void onChanged(@Nullable List<Animal> animals) {
                adapter.setAnimal(animals);
            }
        });

        adapter.setOnClickListener(new AnimalAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Animal animal) {
                Intent data = new Intent();
                data.putExtra(EXTRA_ID, animal.getId());

                //setResult(RESULT_OK, data);
                //finish();
                Toast.makeText(getApplicationContext(), "Id:" + String.valueOf(animal.getId()), Toast.LENGTH_LONG).show();
            }
        });

    }


}
