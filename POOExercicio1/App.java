package POOExercicio1;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Cadastro pessoa1 = new Cadastro();//default/construtor vazio
        // atribuindo via construtot
        Cadastro pessoa1 = new Cadastro("Fabiana", 1.70, 1988, 12, 20);
        // atribuir valores aos atributos via set
        System.out.println("Informe o Nome");
        pessoa1.setNome(sc.next());

        //utilizando os métodos para o objeto
        pessoa1.calcularIdade();
        pessoa1.imprimirInfo();
        sc.close();

        pessoa1.imprimirInfo();
        System.out.println("A idade é"+pessoa1.calcularIdade());
        sc.close();
    }
}
