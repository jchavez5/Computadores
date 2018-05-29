package com.josechavez.computador;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Josechavez on 28/05/2018.
 */

class AdaptadorComputador extends RecyclerView.Adapter<AdaptadorComputador.ComputadorViewHolder>{
    private ArrayList<Computador> computador;
    private OnComputadorClickListener clickListener;
    public AdaptadorComputador(ArrayList<Computador> computadores, OnComputadorClickListener clickListener) {
        this.computador = computadores;
        this.clickListener = clickListener;
    }

    @Override
    public ComputadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_computador, parent, false);
        return new ComputadorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ComputadorViewHolder holder, int position) {
        final Computador c = computador.get(position);
        holder.foto.setImageResource(c.getFoto());
        holder.marca.setText(c.getMarca());
        holder.ram.setText(c.getRam());
        holder.color.setText(c.getColor());
        holder.sistema.setText(c.getSistema());

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onComputadorClick(c);
            }
        });
    }
    @Override
    public int getItemCount() {
        return computador.size();
    }

    public static class ComputadorViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView marca;
        private TextView ram;
        private TextView color;
        private TextView sistema;
        private View v;

        public ComputadorViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.imgFoto);
            marca = v.findViewById(R.id.lblMarca);
            ram = v.findViewById(R.id.lblRam);
            color = v.findViewById(R.id.lblColors);
            sistema= v.findViewById(R.id.lblsistems);

        }

    }
    public interface OnComputadorClickListener{
        void onComputadorClick(Computador c);
    }

}
