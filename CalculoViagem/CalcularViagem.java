package CalculoViagem;

import java.util.Scanner;

public class CalcularViagem {
    public static void main(String[] args) {
         //obter distância percorrida pelo usuário (Km)
        int distanciaPercorrida = 150;
        /*obter gasto do veículo do usuário (Km/litro)*/
        int gastoVeiculo = 10;
        // Obter preço da gasolina (R$/Litro)
        float preçoGasolina = 5;
        //Calcular quanto vai gastar na viajem
        float totalGasolina = distanciaPercorrida/gastoVeiculo;
        //Calcular Total de Gasto
        float totalDeGasto = totalGasolina*preçoGasolina;
       //Mostre quantos litros irá gastar
        System.out.println("O total de gasolina gasta será "+totalGasolina+" Litros");
        //Mostre quantos reais irá gastar
        System.out.println("O Total de reais gasto será "+totalDeGasto+" R$");





    

       
    }
}