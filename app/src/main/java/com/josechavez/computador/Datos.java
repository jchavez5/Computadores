package com.josechavez.computador;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by Josechavez on 28/05/2018.
 */

class Datos {
    private static ArrayList<Computador>  computador = new ArrayList();
    private static String db = "computador";
    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    public static void guardar(Computador c){
        databaseReference.child(db).child(c.getId()).setValue(c);

    }

    public static ArrayList<Computador>obtener(){
        return computador;
    }

    public static String getId(){
        return databaseReference.push().getKey();
    }

    public static void setCarros(ArrayList<Computador> carros){
        Datos.computador= carros;

    }
    public static void eliminarComputador(Computador c){
        databaseReference.child(db).child(c.getId()).removeValue();
    }
}
