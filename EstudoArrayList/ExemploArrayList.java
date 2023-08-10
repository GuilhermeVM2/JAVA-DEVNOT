package EstudoArrayList;

import java.util.ArrayList;

public class ExemploArrayList {
    //Atributo
    //Declarando o ArrayList do Tipo String
    ArrayList<String> carros = new ArrayList<>();
    //métodos
    public void teste(){
        //Adicionar Valores ao ArrayList;
        carros.add("uno");
        carros.add("Chevette");
        carros.add("Opala");
        carros.add("Eclipse");
        carros.add("Mazda rx7");
        //Imprimir toda a lista
        System.out.println(carros);
        System.out.println(carros.get(4));
        //percorrendo a lista com o FOR
        for (int i = 0; i < carros.size(); i++) {
            System.out.println(carros.get(i));
        }
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
    ArrayList<Integer> idades = new ArrayList<>();
    
}

}
