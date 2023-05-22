package Formativa;

import java.util.Random;
import java.util.Scanner;

public class Formativa {
    Random rd = new Random(0);
    Scanner sc = new Scanner(System.in);

    public void exercicio2() {
        int nSorteado = rd.nextInt(1000);
        int cont = 1;
        System.out.println("Digite um N°");
        int nDigitado = sc.nextInt();
        while (nSorteado != nDigitado) {
            System.out.println("DIgite outro N°");
            nDigitado = sc.nextInt();
            cont++;
            // condição
            if (nDigitado == nSorteado) {
                // vai sair do loop
            } else if (nDigitado > nSorteado) {
                System.out.println("O N° é maior que o Sorteado");
            } else {
                System.out.println("O N° é Menor que o Sorteado");
            }
        }
        System.out.println("Parabens você acertou");
        System.out.println("Em " + cont + " tentativas");
    }

    // atividade3
    // criar um vetor 100-1000 itens
    public void exercicio3() {
        int vetor[] = new int[rd.nextInt(900) + 100];
        int contImparNaPar = 0;
        int contParNaImpar = 0;
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rd.nextInt(100) + 1;

        }
        // procurar os n° Impares
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 == 1) { // resto = 1
                System.out.println(vetor[i]);
            if (i%2==1) { //casa par
                contImparNaPar++;
            }
        }
        }
        // procurar os n° pares
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 == 0) { // resto = 0
                System.out.println(vetor[i]);
            }
            if (i%2==0) { //casa impar
                contParNaImpar++;
            }
        }
        //contar  os impares na casa par
        for (int i = 0; i < vetor.length; i+=2) {
            if (vetor[i]%2==0) {
                contParNaImpar++;
            }
        }
        //contar os Pares nas casa Impar
        for (int i = 0; i < vetor.length; i+=2) {
            if (vetor[i]%2==1) {
                contImparNaPar++;
            }
        }
    }
}
