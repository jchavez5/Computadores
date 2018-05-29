package com.josechavez.computador;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleComputador extends AppCompatActivity {
    private TextView txtMarcaDetalle;
    private TextView txtRamDetalle;
    private TextView txtColorDetalle;
    private TextView txtTipoDetalle;
    private TextView txtSistemaetalle;
    private ImageView fot;
    private String id,marca,ram,color,tipo,sistema;
    private int foto;
    private Intent i;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_computador);
        txtMarcaDetalle = findViewById(R.id.txtMarcaDetalle);
        txtRamDetalle = findViewById(R.id.txtRamDetalle);
        txtColorDetalle = findViewById(R.id.txtColorDetalle);
        txtTipoDetalle = findViewById(R.id.txtTipoDetalle);
        txtSistemaetalle=findViewById(R.id.txtSistemasDetalle);
        fot = findViewById(R.id.foto);
        i =getIntent();
        bundle = i.getBundleExtra("datos");
        marca = bundle.getString("marca");
        ram = bundle.getString("ram");
        color = bundle.getString("color");
        tipo = bundle.getString("tipo");
        sistema = bundle.getString("sistema");
        foto = bundle.getInt("foto");
        id = bundle.getString("id");

        txtMarcaDetalle.setText(marca);
        txtRamDetalle.setText(ram);
        txtColorDetalle.setText(color); ;
        txtTipoDetalle.setText(tipo);
        txtSistemaetalle.setText(sistema);
        fot = findViewById(R.id.foto);

    }
    public void eliminar(View v){
        String positivo, negativo;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.eliminar));
        builder.setMessage(getResources().getString(R.string.pregunta_eliminacion));
        positivo = getResources().getString(R.string.positivo);
        negativo = getResources().getString(R.string.negativo);

        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Computador c = new Computador(id);
                c.eliminar();
                onBackPressed();
            }
        });

        builder.setNegativeButton(negativo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }


    public void onBackPressed() {
        finish();
        Intent i = new Intent(DetalleComputador.this,Principal.class);
        startActivity(i);
    }
}
