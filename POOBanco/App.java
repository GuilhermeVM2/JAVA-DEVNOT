package POOBanco;

import java.util.Random;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        Random rd = new Random();
        //criar um array de objetos
        TipoConta conta[] = new TipoConta[10];
        //criar e preencher os objetos 
        for (int i = 0; i < conta.length; i++) {
            conta[i]=new TipoConta(); //construtor de objeto
            //preencher
            conta[i].setNome(JOptionPane.showInputDialog("Informe o Nome"));
            


        }

       
    }
}
