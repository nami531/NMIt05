package com.example.app;

import java.util.ArrayList;
import java.util.Random;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.app.model.EstadoJuego;
import com.example.app.model.Intento;
import com.example.app.model.MasterMind;

@Service
@Scope("session")
public class MasterMindService {

    public MasterMind masterMind;
    private ArrayList<Integer> tries = new ArrayList<>(); 

    public void nuevoJuego(int numLength, int maxTries) {
        this.tries = new ArrayList<>(); 
        masterMind = new MasterMind();
        masterMind.setMaxIntentos(maxTries);
        masterMind.setTamNumero(numLength);
        do {
            masterMind.setNumeroSecreto(cadenaAlAzar(masterMind.getTamNumero()));
        } while (cadenaConDuplicados(masterMind.getNumeroSecreto()));
        masterMind.getListaIntentos().clear();
        masterMind.setEstadoJuego(EstadoJuego.JUGANDO);
        System.out.println("=====> Num secreto: " + masterMind.getNumeroSecreto()); // solo para testing
    }

    public void comprobarIntento(String intento) {
        
        if (masterMind.getEstadoJuego() != EstadoJuego.JUGANDO)
            return;

        if (!intento.matches("\\d+")) {
            throw new NumberFormatException("Invalid number format for string");
        }  
        if (intento.length() != masterMind.getTamNumero()){
            throw new RuntimeException("You introduced a number with diferent length than the secret number"); 
        }

        if (cadenaConDuplicados(intento)){
            throw new RuntimeException("You introduced a number with number duplicated"); 
        } 
        
        Integer tryInt = Integer.parseInt(intento);         
        if (tries.contains(tryInt)){
            throw new RuntimeException("You've already introduced this number"); 
        }
        tries.add(tryInt); 
        int bienColocados = 0, malColocados = 0;
        String numeroSecreto = masterMind.getNumeroSecreto();
        for (int cont = 0; cont < intento.length(); cont++) {
            char letra = intento.charAt(cont);
            if (letra == numeroSecreto.charAt(cont))
                bienColocados++;
            else if (numeroSecreto.indexOf(letra) != -1)
                malColocados++;
        }
        masterMind.getListaIntentos().add(new Intento(intento, bienColocados, malColocados));
        if (bienColocados == masterMind.getTamNumero())
            masterMind.setEstadoJuego(EstadoJuego.GANO);
        if (masterMind.getListaIntentos().size() >= masterMind.getMaxIntentos())
            masterMind.setEstadoJuego(EstadoJuego.PERDIO);
    }

    private boolean cadenaConDuplicados(String cad) {
        for (int i = 0; i < cad.length(); i++) {
            char c = cad.charAt(i);
            if (cad.indexOf(c, i + 1) != -1)
                return true;
        }
        return false;
    }

    private String cadenaAlAzar(int tamanho) {
        Random random = new Random();
        String cad = "";
        int x;
        for (int i = 0; i < tamanho; i++) {
            x = random.nextInt(10);
            cad += Integer.toString(x);
        }
        return cad;
    }
}
