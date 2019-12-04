package br.edu.farol.gadoplus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.edu.farol.gadoplus.R;
import br.edu.farol.gadoplus.model.PesagemAnimal;

public class PesagemAnimalAdapter extends RecyclerView.Adapter<PesagemAnimalAdapter.PesagemAnimalViewHolder> {

    private List<PesagemAnimal> pesagemAnimals;
    private OnItemClickListener listener;

    @Override
    public PesagemAnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new PesagemAnimalViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(PesagemAnimalViewHolder viewHolder, int i) {

        viewHolder.nome.setText(String.valueOf(pesagemAnimals.get(i).getPeso())+" Kg");
        viewHolder.descricao.setText("Animal: " +String.valueOf(pesagemAnimals.get(i).getAnimalId()));
        //viewHolder.hectares.setText(String.valueOf(pesagemAnimals.get(i).getHectares()) + " hec");

    }

    @Override
    public int getItemCount() {
        if (pesagemAnimals != null)
            return pesagemAnimals.size();
        else return 0;
    }

    public void setPesagemAnimal(List<PesagemAnimal> pesagemAnimals) {
        this.pesagemAnimals = pesagemAnimals;
        notifyDataSetChanged();
    }

    class PesagemAnimalViewHolder extends RecyclerView.ViewHolder {
        private TextView nome, descricao, hectares;

        public PesagemAnimalViewHolder(View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.text_view_title);
            descricao = itemView.findViewById(R.id.text_view_description);
            hectares = itemView.findViewById(R.id.text_view_priority);

            //itemView.setOnClickListener((View.OnClickListener) this);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION)
                        listener.onItemClick(pesagemAnimals.get(position));
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(PesagemAnimal pesagemAnimal);
    }

    public void setOnClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


}
