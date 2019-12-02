package br.edu.farol.gadoplus.ui.propriedades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import br.edu.farol.gadoplus.adapter.PropriedadeAdapter;
import br.edu.farol.gadoplus.model.Propriedade;


public class PropriedadesFragment extends Fragment {
    public static final int ADD_REQUEST = 1;
    public static final int EDIT_REQUEST = 2;
    public static final int DELETE_REQUEST = 3;


    private PropriedadesViewModel propriedadesViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_propriedades, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        final PropriedadeAdapter adapter = new PropriedadeAdapter();
        recyclerView.setAdapter(adapter);

        propriedadesViewModel = ViewModelProviders.of(this).get(PropriedadesViewModel.class);
        propriedadesViewModel.getAll().observe(this, new Observer<List<Propriedade>>() {
            @Override
            public void onChanged(@Nullable List<Propriedade> propriedades) {
                adapter.setPropriedade(propriedades);
            }
        });

        FloatingActionButton buttonAdd = root.findViewById(R.id.button_add_propriedade);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PropriedadesAddEditActivity.class);
                startActivityForResult(intent, ADD_REQUEST);
            }
        });

        adapter.setOnClickListener(new PropriedadeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Propriedade propriedade) {
                Intent intent = new Intent(getContext(), PropriedadesAddEditActivity.class);
                intent.putExtra(PropriedadesAddEditActivity.EXTRA_ID, propriedade.getId());
                intent.putExtra(PropriedadesAddEditActivity.EXTRA_NOME, propriedade.getNome());
                intent.putExtra(PropriedadesAddEditActivity.EXTRA_HECTARES, propriedade.getHectares());
                intent.putExtra(PropriedadesAddEditActivity.EXTRA_DESCRICAO, propriedade.getDescricao());
                startActivityForResult(intent, EDIT_REQUEST);
            }
        });

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_REQUEST && resultCode == Activity.RESULT_OK) {
            String nome = data.getStringExtra(PropriedadesAddEditActivity.EXTRA_NOME);
            double hectares = data.getDoubleExtra(PropriedadesAddEditActivity.EXTRA_HECTARES, 0);
            String descricao = data.getStringExtra(PropriedadesAddEditActivity.EXTRA_DESCRICAO);

            Propriedade propriedade = new Propriedade(nome, hectares, descricao);
            propriedadesViewModel.insert(propriedade);

            Toast.makeText(getContext(), "Registro salvo", Toast.LENGTH_SHORT).show();
        } else if (requestCode == EDIT_REQUEST && resultCode == Activity.RESULT_OK) {
            int id = data.getIntExtra(PropriedadesAddEditActivity.EXTRA_ID, -1);

            if (id == -1) {
                Toast.makeText(getContext(), "Não é possível salvar!", Toast.LENGTH_SHORT).show();
                return;
            }

            String nome = data.getStringExtra(PropriedadesAddEditActivity.EXTRA_NOME);
            double hectares = data.getDoubleExtra(PropriedadesAddEditActivity.EXTRA_HECTARES, 0);
            String descricao = data.getStringExtra(PropriedadesAddEditActivity.EXTRA_DESCRICAO);

            Propriedade propriedade = new Propriedade(nome, hectares, descricao);
            propriedade.setId(id);
            propriedadesViewModel.update(propriedade);

            Toast.makeText(getContext(), "Registro atualizado", Toast.LENGTH_SHORT).show();
        } else if (resultCode == PropriedadesFragment.DELETE_REQUEST) {

            int id = data.getIntExtra(PropriedadesAddEditActivity.EXTRA_ID, -1);

            if (id == -1) {
                Toast.makeText(getContext(), "Não é possivel deletar!", Toast.LENGTH_SHORT).show();
                return;
            }

            Propriedade propriedade = new Propriedade();
            propriedade.setId(id);
            propriedadesViewModel.delete(propriedade);

            Toast.makeText(getContext(), "Registro atualizado", Toast.LENGTH_SHORT).show();
        }
    }



}