package POOExercicio3;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // criar o objeto elevador
        Elevador elevador1 = new Elevador(10, 10);
        elevador1.iniciar();
        // elevador em funcionamento
        boolean ligado = true;
        int acao = 0;
        while (ligado) {
            System.out.println("Escolha a ação do elevador:\n"
                    + "1. Entrar pessoa\n"
                    + "2. Descer pessoa\n"
                    + "3. Escolha um Andar\n"
                    + "4. Desligar");
        int atuacao = sc.nextInt();
        switch (atuacao) {
            case 1:
                System.out.println("Capacidade" + elevador1.entrar());
                break;
            case 2:
                System.out.println("Capacidade" + elevador1.sair());
                break;
            case 3:
                elevador1.acao(Integer.parseInt(
                        JOptionPane.showInputDialog(
                                "Informe o Andar Desejado")));
                System.out.println(elevador1.getAndarAtual());
                break;
            case 4 :
                ligado = false;

            default:
                JOptionPane.showMessageDialog(null,"Informe uma Ação válida");
                break;
        }
    }
}
}
