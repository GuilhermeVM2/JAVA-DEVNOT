package CalcularVelocidadeMedia;

import java.util.Scanner;

public class VelocidadeMedia {
    public static void main(String[] args) {
        //obter distância percorrida pelo usuário
        int distanciaPercorrida = 150;
        /*obter tempo gasto pelo usuário */
        int tempoGasto = 2;
        // Calcular velocidade média
        float velocidadeMedia = distanciaPercorrida/tempoGasto;
        //Mostre a velocidade média
        System.out.println(velocidadeMedia+" Km/h");
        System.out.println("A velocidade média foi de: "+velocidadeMedia+" Km/h");
    }
}
