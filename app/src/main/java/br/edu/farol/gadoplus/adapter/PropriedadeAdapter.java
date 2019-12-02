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
import br.edu.farol.gadoplus.model.Propriedade;

public class PropriedadeAdapter extends RecyclerView.Adapter<PropriedadeAdapter.PropriedadeViewHolder> {

    private List<Propriedade> propriedades;
    private OnItemClickListener listener;

    @Override
    public PropriedadeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new PropriedadeViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(PropriedadeViewHolder viewHolder, int i) {

        viewHolder.nome.setText(propriedades.get(i).getNome());
        viewHolder.descricao.setText(propriedades.get(i).getDescricao());
        viewHolder.hectares.setText(String.valueOf(propriedades.get(i).getHectares()) + " hec");

    }

    @Override
    public int getItemCount() {
        if (propriedades != null)
            return propriedades.size();
        else return 0;
    }

    public void setPropriedade(List<Propriedade> propriedades) {
        this.propriedades = propriedades;
        notifyDataSetChanged();
    }

    class PropriedadeViewHolder extends RecyclerView.ViewHolder {

        private TextView nome, descricao, hectares;

        public PropriedadeViewHolder(View itemView) {
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
                        listener.onItemClick(propriedades.get(position));
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Propriedade propriedade);
    }

    public void setOnClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    // public PropriedadeAdapter(List<Propriedade> propriedades) {
    //   this.propriedades = propriedades;
    //}


}
