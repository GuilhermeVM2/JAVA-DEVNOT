package Desafio;

import java.util.Scanner;

public class Desafio {
    public void teste () {
        Scanner sc = new Scanner(System.in);;
        System.out.println("Informe a primeira nota");
        double primeiraNota = sc.nextDouble();

        Scanner sc2 = new Scanner(System.in);;
        System.out.println("Informe a segunda nota");
        double segundaaNota = sc2.nextDouble();

        Scanner sc3 = new Scanner(System.in);;
        System.out.println("Informe a segunda nota");
        double frequencia = sc3.nextDouble();

        double media = (primeiraNota+segundaaNota)/2;
        System.out.println("a média é "+media);


    }
}
