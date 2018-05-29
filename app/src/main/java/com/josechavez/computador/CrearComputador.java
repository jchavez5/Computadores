package com.josechavez.computador;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.josechavez.computador.R;

public class CrearComputador extends AppCompatActivity {
    private EditText txtRam;
    private Spinner spn_marca,spn_color,spn_tipo,spn_sistema;
    private String [] opc_marca,opc_color,opc_tipo,opc_sistema;
    private ArrayAdapter<String> adp_marca,adp_color,adp_tipo,adp_sistema;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_computador);
        txtRam = findViewById(R.id.txtRam);
        //Spinner de Marcas
        spn_marca = findViewById(R.id.lst_marca);
        opc_marca = this.getResources().getStringArray(R.array.lst_marca);
        adp_marca = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc_marca);
        spn_marca.setAdapter(adp_marca);
        //Spinner de Tipos
        spn_tipo = findViewById(R.id.lst_tipo);
        opc_tipo = this.getResources().getStringArray(R.array.lst_tipo);
        adp_tipo = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc_tipo);
        spn_tipo.setAdapter(adp_tipo);
        //Spinner de Colores
        spn_color = findViewById(R.id.lst_color);
        opc_color = this.getResources().getStringArray(R.array.lst_color);
        adp_color = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc_color);
        spn_color.setAdapter(adp_color);
        //Spinner de Sistema
        spn_sistema = findViewById(R.id.lst_sistema);
        opc_sistema = this.getResources().getStringArray(R.array.lst_sitema);
        adp_sistema = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc_sistema);
        spn_sistema.setAdapter(adp_sistema);


    }
    public String obtenerCampo(Spinner spinner){
        String cadena="";
        cadena=spinner.getSelectedItem().toString();
        //Toast.makeText(this,cadena,Toast.LENGTH_LONG).show();
        return  cadena;
    }
    public boolean validar(EditText txt,String error){
        if (txt.getText().toString().equals("")) {
        txt.setError(error);
        return false;
    }
        return true;
    }


    public int Numerofoto(Spinner spinner){
        int foto=0;
        int posicion=spinner.getSelectedItemPosition();
        if (posicion==0){
            foto=R.drawable.hp;
        }
        if (posicion==1){
            foto=R.drawable.acer;
        }
        if (posicion==2){
            foto=R.drawable.apple;
        }
        if (posicion==3){
            foto=R.drawable.lenovo;
        }
        return foto;
    }

    public void guardar(View view){
        if (validar(txtRam,getResources().getString(R.string.error))){

            String ram,id;
            String marca,color,tipo,sistema;
            int foto;
            ram=txtRam.getText().toString();
            marca=obtenerCampo(spn_marca);
            tipo=obtenerCampo(spn_tipo);
            color=obtenerCampo(spn_color);
            sistema=obtenerCampo(spn_sistema);
            id= Datos.getId();
            foto=Numerofoto(spn_marca);

            Computador c=new Computador(id,marca,ram,color,tipo,sistema,foto);
            c.guardar();
            Snackbar.make(view, getResources().getString(R.string.guardado),Snackbar.LENGTH_SHORT).setAction("Action",null).show();
            limpiar();
        }
    }
    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        txtRam.setText("");
        spn_marca.setSelection(0);
        spn_tipo.setSelection(0);
        spn_color.setSelection(0);
        spn_sistema.setSelection(0);


    }
    public void onBackPressed(){
        finish();
        Intent i = new Intent(CrearComputador.this,Principal.class);
        startActivity(i);
    }
}
