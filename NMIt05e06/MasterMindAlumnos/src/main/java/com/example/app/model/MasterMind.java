package com.example.app.model;

import java.util.ArrayList;

public class MasterMind {
    private String numeroSecreto;
    private ArrayList<Intento> listaIntentos;
    private EstadoJuego estadoJuego;
    public  int tamNumero ;
    
    public  int maxIntentos ;

    

    public MasterMind() {
        listaIntentos = new ArrayList<>();
    }

    public String getNumeroSecreto() {
        return numeroSecreto;
    }

    public void setNumeroSecreto(String numeroSecreto) {
        this.numeroSecreto = numeroSecreto;
    }

    public ArrayList<Intento> getListaIntentos() {
        return listaIntentos;
    }

    public void setListaIntentos(ArrayList<Intento> listaIntentos) {
        this.listaIntentos = listaIntentos;
    }

    public EstadoJuego getEstadoJuego() {
        return estadoJuego;
    }

    public void setEstadoJuego(EstadoJuego estadoJuego) {
        this.estadoJuego = estadoJuego;
    }
    public int getTamNumero() {
        return tamNumero;
    }

    public void setTamNumero(int tamNumero) {
        this.tamNumero = tamNumero;
    }
    
    public int getMaxIntentos() {
        return maxIntentos;
    }

    public void setMaxIntentos(int maxIntentos) {
        this.maxIntentos = maxIntentos;
    }
}
