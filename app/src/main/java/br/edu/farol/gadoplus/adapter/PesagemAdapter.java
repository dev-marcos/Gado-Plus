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
import br.edu.farol.gadoplus.model.Pesagem;

public class PesagemAdapter extends RecyclerView.Adapter<PesagemAdapter.PesagemViewHolder> {

    private List<Pesagem> pesagems;
    private OnItemClickListener listener;

    @Override
    public PesagemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new PesagemViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(PesagemViewHolder viewHolder, int i) {

    //    viewHolder.nome.setText(pesagems.get(i).getNome());
     //   viewHolder.descricao.setText(pesagems.get(i).getDescricao());
     //   viewHolder.hectares.setText(String.valueOf(pesagems.get(i).getHectares()) + " hec");

    }

    @Override
    public int getItemCount() {
        if (pesagems != null)
            return pesagems.size();
        else return 0;
    }

    public void setPesagem(List<Pesagem> pesagems) {
        this.pesagems = pesagems;
        notifyDataSetChanged();
    }

    class PesagemViewHolder extends RecyclerView.ViewHolder {

        private TextView nome, descricao, hectares;

        public PesagemViewHolder(View itemView) {
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
                        listener.onItemClick(pesagems.get(position));
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Pesagem pesagem);
    }

    public void setOnClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    // public PesagemAdapter(List<Pesagem> pesagems) {
    //   this.pesagems = pesagems;
    //}


}