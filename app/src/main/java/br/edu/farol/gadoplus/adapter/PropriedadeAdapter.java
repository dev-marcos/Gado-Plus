package br.edu.farol.gadoplus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.farol.gadoplus.R;
import br.edu.farol.gadoplus.model.Propriedade;

public class PropriedadeAdapter extends RecyclerView.Adapter<PropriedadeAdapter.PropriedadeViewHolder>  {

    public static class PropriedadeViewHolder extends RecyclerView.ViewHolder {

        TextView nome, descricao, hectares;

        PropriedadeViewHolder(View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.tv_item_1);
            descricao = itemView.findViewById(R.id.tv_item_2);
            hectares = itemView.findViewById(R.id.tv_item_3);
        }
    }


    List<Propriedade> propriedades;

    public PropriedadeAdapter(List<Propriedade> propriedades) {
        this.propriedades = propriedades;
    }

    @Override
    public PropriedadeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        PropriedadeViewHolder pvh = new PropriedadeViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PropriedadeViewHolder viewHolder, int i) {

        viewHolder.nome.setText(propriedades.get(i).getNome());
        viewHolder.descricao.setText(propriedades.get(i).getDescricao());
        viewHolder.hectares.setText("Hectares: " + String.valueOf(propriedades.get(i).getHectares()));

    }

    @Override
    public int getItemCount() {
        if (propriedades != null)
            return propriedades.size();
        else return 0;
    }
}
