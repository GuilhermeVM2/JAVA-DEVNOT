import javax.swing.JOptionPane;

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        // Criar uma classe Carros - Atributos e métodos - ok
        // App
        List<Carros> listaCarros = new ArrayList();
        boolean aberto = true;
        while (aberto) {
            int acao = Integer.parseInt(JOptionPane.showInputDialog("1-Cadastro\n2- Lista\n3-Consultar um carro\n4-apagar carro"));
            if (acao == 1) {// 1- Cadastrar Carros na lista
                // Criar um objeto
                String marcaCar = JOptionPane.showInputDialog("Marca do carro");
                String modeloCar = JOptionPane.showInputDialog("Modelo do carro");
                String anoCar = JOptionPane.showInputDialog("Ano do carro");
                String corCar = JOptionPane.showInputDialog("Cor do carro");
                Carros car = new Carros(marcaCar, modeloCar, anoCar, corCar);
                listaCarros.add(car);
            } else if (acao == 2) {// 2- Listar Carros cadastrados
                String listar = "";
                for (Carros carros : listaCarros) {
                    listar += carros.ImprimirLN();
                }
                JOptionPane.showMessageDialog(null, listar);
            }else if(acao==3){
                String listar="";
                int i=0;
                for (Carros carros : listaCarros) {
                    listar+=i+carros.ImprimirLN();
                    i++;
                }
                int acao2=Integer.parseInt(
                    JOptionPane.showInputDialog(
                        "Escolah o Carro:\n"+listar));
                        listaCarros.get(acao2).imprimir();
            }else if(acao==4){
                String listar="";
                int i=0;
                for (Carros carros : listaCarros) {
                    listar+=i+carros.ImprimirLN();
                    i++;
                }
                int acao2=Integer.parseInt(
                    JOptionPane.showInputDialog(
                        "Escolah o Carro Para Excluir:\n"+listar));
                        listaCarros.get(acao2).imprimir();
                        listaCarros.remove(acao2);

        }
        // 1- Cadastrar carros na Lista
        // 2- Listar Carros Cadastrados
        // 3- Consultar um carro cadastrado
        // 4- Apagar carro cadastrado

    }
}
}
