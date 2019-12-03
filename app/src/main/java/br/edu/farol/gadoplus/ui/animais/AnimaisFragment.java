package br.edu.farol.gadoplus.ui.animais;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import br.edu.farol.gadoplus.R;
import br.edu.farol.gadoplus.adapter.AnimalAdapter;
import br.edu.farol.gadoplus.adapter.PropriedadeAdapter;
import br.edu.farol.gadoplus.model.Animal;
import br.edu.farol.gadoplus.model.Propriedade;
import br.edu.farol.gadoplus.ui.propriedade.PropriedadeAddEditActivity;
import br.edu.farol.gadoplus.ui.propriedade.PropriedadeFragment;
import br.edu.farol.gadoplus.ui.propriedade.PropriedadeViewModel;
import br.edu.farol.gadoplus.util.Util;

public class AnimaisFragment extends Fragment {
    public static final int ADD_REQUEST = 1;
    public static final int EDIT_REQUEST = 2;
    public static final int DELETE_REQUEST = 3;

    private AnimaisViewModel animaisViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        animaisViewModel = ViewModelProviders.of(this).get(AnimaisViewModel.class);
        View root = inflater.inflate(R.layout.fragment_animais, container, false);


        final RecyclerView recyclerView = root.findViewById(R.id.rv_animais);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        final AnimalAdapter adapter = new AnimalAdapter();
        recyclerView.setAdapter(adapter);

        final TextView tvVazio = root.findViewById(R.id.tv_animais_nenhum_registro);


        animaisViewModel.getAll().observe(this, new Observer<List<Animal>>() {
            @Override
            public void onChanged(@Nullable List<Animal> animals) {
                if (animals.size()>0){
                    tvVazio.setVisibility(View.GONE);
                    adapter.setAnimal(animals);
                }else{
                    tvVazio.setVisibility(View.VISIBLE);
                }

            }
        });

        FloatingActionButton buttonAdd = root.findViewById(R.id.button_add_animais);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AnimaisAddEditActivity.class);
                startActivityForResult(intent, ADD_REQUEST);
            }
        });

        adapter.setOnClickListener(new AnimalAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Animal animal) {
                Intent intent = new Intent(getContext(), AnimaisAddEditActivity.class);
                intent.putExtra(AnimaisAddEditActivity.EXTRA_ID, animal.getId());
                intent.putExtra(AnimaisAddEditActivity.EXTRA_NOME, animal.getNome());
                intent.putExtra(AnimaisAddEditActivity.EXTRA_LOTE_ID, animal.getLoteId());
                intent.putExtra(AnimaisAddEditActivity.EXTRA_SEXO, animal.getSexo());
                intent.putExtra(AnimaisAddEditActivity.EXTRA_DT_ENTRADA, animal.getDtEntrada());
                intent.putExtra(AnimaisAddEditActivity.EXTRA_DT_PRIMEIRA_PESAGEM, animal.getDtPrimeiraPesagem());
                intent.putExtra(AnimaisAddEditActivity.EXTRA_PRIMEIRO_PESO, animal.getPrimeiroPeso());
                intent.putExtra(AnimaisAddEditActivity.EXTRA_RACA_ID, animal.getRacaId());
                intent.putExtra(AnimaisAddEditActivity.EXTRA_PRECO_COMPRA, animal.getPrecoCompra());
                intent.putExtra(AnimaisAddEditActivity.EXTRA_DT_NASCIMENTO, animal.getDtNascimento());
                intent.putExtra(AnimaisAddEditActivity.EXTRA_DT_DESMAME, animal.getDtDesmame());
                intent.putExtra(AnimaisAddEditActivity.EXTRA_OBSERVACOES, animal.getObservacoes());
                startActivityForResult(intent, EDIT_REQUEST);
            }
        });

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((resultCode == Activity.RESULT_OK)&&(requestCode == ADD_REQUEST || requestCode == EDIT_REQUEST)){
            Animal animal = new Animal();

            animal.setNome(data.getStringExtra(AnimaisAddEditActivity.EXTRA_NOME));
            animal.setLoteId(data.getIntExtra(AnimaisAddEditActivity.EXTRA_LOTE_ID,0));
            animal.setSexo(data.getStringExtra(AnimaisAddEditActivity.EXTRA_SEXO));
            animal.setDtEntrada(data.getStringExtra(AnimaisAddEditActivity.EXTRA_DT_ENTRADA));
            animal.setDtPrimeiraPesagem(data.getStringExtra(AnimaisAddEditActivity.EXTRA_DT_PRIMEIRA_PESAGEM));
            animal.setPrimeiroPeso(data.getDoubleExtra(AnimaisAddEditActivity.EXTRA_PRIMEIRO_PESO, 0));
            animal.setRacaId(data.getIntExtra(AnimaisAddEditActivity.EXTRA_RACA_ID,0));
            animal.setPrecoCompra(data.getDoubleExtra(AnimaisAddEditActivity.EXTRA_PRECO_COMPRA,0));
            animal.setDtEntrada(data.getStringExtra(AnimaisAddEditActivity.EXTRA_DT_NASCIMENTO));
            animal.setDtDesmame(data.getStringExtra(AnimaisAddEditActivity.EXTRA_DT_DESMAME));
            animal.setObservacoes(data.getStringExtra(AnimaisAddEditActivity.EXTRA_OBSERVACOES));

            switch (requestCode){
                case ADD_REQUEST:
                    animaisViewModel.insert(animal);
                    Toast.makeText(getContext(), "Registro salvo", Toast.LENGTH_SHORT).show();
                    break;
                case EDIT_REQUEST:
                    int id = data.getIntExtra(PropriedadeAddEditActivity.EXTRA_ID, -1);
                    if (id == -1) {
                        Toast.makeText(getContext(), "Não é possível salvar!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    animal.setId(id);
                    animaisViewModel.update(animal);
                    Toast.makeText(getContext(), "Registro atualizado", Toast.LENGTH_SHORT).show();
                    break;
            }
        }else if (resultCode == PropriedadeFragment.DELETE_REQUEST) {

            int id = data.getIntExtra(PropriedadeAddEditActivity.EXTRA_ID, -1);

            if (id == -1) {
                Toast.makeText(getContext(), "Não é possivel deletar!", Toast.LENGTH_SHORT).show();
                return;
            }

            Animal animal = new Animal();
            animal.setId(id);
            animaisViewModel.delete(animal);

            Toast.makeText(getContext(), "Registro deletado", Toast.LENGTH_SHORT).show();
        }

    }
}