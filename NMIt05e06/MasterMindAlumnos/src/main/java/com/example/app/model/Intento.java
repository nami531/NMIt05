package com.example.app.model;

public class Intento {

    private String combinacion;
    private int bienColocados;
    private int malColocados;

    public Intento(String combinacion, int bienColocados, int malColocados) {
        this.combinacion = combinacion;
        this.bienColocados = bienColocados;
        this.malColocados = malColocados;
    }

    public String getCombinacion() {
        return combinacion;
    }

    public void setCombinacion(String combinacion) {
        this.combinacion = combinacion;
    }

    public int getBienColocados() {
        return bienColocados;
    }

    public void setBienColocados(int bienColocados) {
        this.bienColocados = bienColocados;
    }

    public int getMalColocados() {
        return malColocados;
    }

    public void setMalColocados(int malColocados) {
        this.malColocados = malColocados;
    }

}
