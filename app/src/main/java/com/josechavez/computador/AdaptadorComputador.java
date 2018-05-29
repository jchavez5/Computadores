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

class AdaptadorComputador {
    private ArrayList<Computador> computador;
    private OnComputadorClickListener clickListener;
    public AdaptadorCarro(ArrayList<Computador> carros, OnComputadorClickListener clickListener) {
        this.computador = carros;
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
        holder.tipo.setText(c.getTipo());

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
        private TextView tipo;
        private TextView sistema;
        private View v;

        public ComputadorViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.imgFoto);
            placa = v.findViewById(R.id.lblPlaca);
            marca = v.findViewById(R.id.lblMarca);
            modelo = v.findViewById(R.id.lblModelo);
            precio = v.findViewById(R.id.lblPrecio);
            color = v.findViewById(R.id.lblColor);

        }

    }

}
