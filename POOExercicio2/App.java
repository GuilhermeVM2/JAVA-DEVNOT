package POOExercicio2;

import java.security.MessageDigest;
import java.util.Random; 
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;

public class App {
    
    public static void main (String[] args) {
        Random rd = new Random();
        //criar um array de objetos
        Agenda contatos[] = new Agenda[2];
        //criar e preencher os objetos 
        for (int i = 0; i < contatos.length; i++) {
            contatos[i] = new Agenda(); //construtor de objeto
            //preencher
            contatos[i].setNome(JOptionPane.showInputDialog(contatos));
            contatos[i].setIdade(i+18);
            contatos[i].setAltura(rd.nextDouble(1.5,2));
        }
        String nomeBuscado = JOptionPane.showInputDialog("Informe o Nome buscado");
        int cont = 0;// contador 
        boolean procure = true;
        while (procure) {//Enquanto procure for verdadeiro loop
            if (nomeBuscado.equals(contatos[cont].getNome())) {
                procure = false;//parar o laço
                JOptionPane.showMessageDialog(null,
                "idade" +contatos[cont].getIdade()
                +"\n Altura: "+contatos[cont].getAltura());

            }
            cont++;

            
        }

    }
}
