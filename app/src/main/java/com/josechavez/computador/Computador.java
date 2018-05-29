package com.josechavez.computador;

/**
 * Created by Josechavez on 28/05/2018.
 */

class Computador {
    private String id;
    private String marca;
    private String ram;
    private String color;
    private String tipo;
    private String sistema;
    private int foto;

    public Computador() {
    }

    public Computador(String id, String marca, String ram, String color, String tipo, String sistema, int foto) {
        this.id = id;
        this.marca = marca;
        this.ram = ram;
        this.color = color;
        this.tipo = tipo;
        this.sistema = sistema;
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void guardar(){
        Datos.guardar(this);
    }
  //  public void eliminar(){
   //     Datos.eliminarComputador(this);
    //}
}

