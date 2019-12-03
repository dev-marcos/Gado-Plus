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
import br.edu.farol.gadoplus.model.Gasto;

public class GastoAdapter extends RecyclerView.Adapter<GastoAdapter.GastoViewHolder> {

    private List<Gasto> gastos;
    private OnItemClickListener listener;

    @Override
    public GastoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new GastoViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(GastoViewHolder viewHolder, int i) {

    //    viewHolder.nome.setText(gastos.get(i).getNome());
    //    viewHolder.descricao.setText(gastos.get(i).getDescricao());
     //   viewHolder.hectares.setText(String.valueOf(gastos.get(i).getHectares()) + " hec");

    }

    @Override
    public int getItemCount() {
        if (gastos != null)
            return gastos.size();
        else return 0;
    }

    public void setGasto(List<Gasto> gastos) {
        this.gastos = gastos;
        notifyDataSetChanged();
    }

    class GastoViewHolder extends RecyclerView.ViewHolder {

        private TextView nome, descricao, hectares;

        public GastoViewHolder(View itemView) {
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
                        listener.onItemClick(gastos.get(position));
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Gasto gasto);
    }

    public void setOnClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    // public GastoAdapter(List<Gasto> gastos) {
    //   this.gastos = gastos;
    //}


}
