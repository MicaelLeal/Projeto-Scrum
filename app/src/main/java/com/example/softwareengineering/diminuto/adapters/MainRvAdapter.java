package com.example.softwareengineering.diminuto.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.softwareengineering.diminuto.R;
import com.example.softwareengineering.diminuto.models.Instrumento;

import java.util.List;


public class MainRvAdapter extends RecyclerView.Adapter<MainRvAdapter.ViewHolder> {

    private Context context;
    private List<Instrumento> instrumentos;

    public MainRvAdapter(Context context, List<Instrumento> instrumentos) {
        this.context = context;
        this.instrumentos = instrumentos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_rv_main, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNome.setText(instrumentos.get(position).getNome());
        holder.txtDesc.setText(instrumentos.get(position).getDescricacao());
        holder.txtValor.setText(String.valueOf(instrumentos.get(position).getValor()));
    }

    @Override
    public int getItemCount() {
        return instrumentos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        protected TextView txtNome;
        protected TextView txtDesc;
        protected TextView txtValor;

        public ViewHolder(View itemView) {
            super(itemView);

            txtNome = itemView.findViewById(R.id.txt_item_rv_main_nome);
            txtDesc = itemView.findViewById(R.id.txt_item_rv_main_descricao);
            txtValor = itemView.findViewById(R.id.txt_item_rv_main_valor);
        }
    }

}
