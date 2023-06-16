package POOBanco;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        Random rd = new Random();
        // criar um array de objetos
        TipoConta conta[] = new TipoConta[1];
        // criar e preencher os objetos
        boolean ligado = true;
        Scanner sc = new Scanner(System.in);
        int acao = 0;
        while (ligado) {
            for (int i = 0; i < conta.length; i++) {
            
        int atuacao = Integer.parseInt(JOptionPane.showInputDialog("Escolha a ação desejada:\n"
                    + "1. Criar Conta\n"
                    + "2. Acessar Conta\n"
                    + "3. Sair\n"));

        switch (atuacao) {
            case 1:
                int opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha a ação desejada:\n"
                    + "1. Pessoa Jurídica\n"
                    + "2. Pessoa Física\n"
                    + "3. Sair\n"));

                    if (opcao == 1) {
                        
                    }

                break;
            case 2:
                break;
            case 3:
            ligado=false;
                break;
            default:
                JOptionPane.showMessageDialog( null,"Erro ");
                break;
        }  
        }
    }


    }
}
