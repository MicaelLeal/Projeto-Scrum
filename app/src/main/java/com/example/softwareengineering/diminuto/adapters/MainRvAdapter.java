package com.example.softwareengineering.diminuto.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.softwareengineering.diminuto.R;

import java.util.List;


public class MainRvAdapter extends RecyclerView.Adapter<MainRvAdapter.ViewHolder> {

    private Context context;
//    private List<>

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
//        return new ViewHolder(LayoutInflater.from(context)
//                .inflate(R.layout.todo, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        protected TextView txtNome;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
