package EstudoArrayList;

import java.util.*;

import javax.swing.JOptionPane;

public class ExemploArrayList {
    //Atributo
    //Declarando o ArrayList do Tipo String
    ArrayList<String> carros = new ArrayList<>();
    ArrayList<Integer> num = new ArrayList<>();
    
    //métodos
    public void teste(){
        //Adicionar Valores ao ArrayList;
        carros.add("uno");
        carros.add("Chevette");
        carros.add("Opala");
        carros.add("Eclipse");
        carros.add("Mazda rx7");
        //ordenando a lista
        Collections.sort(carros);
        //Imprimir toda a lista
        System.out.println(carros);
        System.out.println(carros.get(4));
        //percorrendo a lista com o FOR
        for (int i = 0; i < carros.size(); i++) {
            System.out.println(carros.get(i));
        }
        //Collection.reverse(Invertendo as listas)
        Collections.reverse(carros);
        //percorendo a lista com FOR-EACH
            for (String i : carros) {
                System.out.println(i);
            }
        //apagar toda a lista
        carros.clear();
        System.out.println(carros);
    }
public void exercicio(){
    //criar um arraylist (Interger) + 5 Valores
    //Preencher 5 n° int
    //ordenando a lista
        Collections.sort(num);
    for (int i = 0; i < 5; i++) {
        num.add(Integer.parseInt(JOptionPane.showInputDialog("Digite o número")));
    }
    for (int i : num) {
        System.out.println(i);
    }
}

}
