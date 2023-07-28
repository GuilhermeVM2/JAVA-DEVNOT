package RevisaoFPOO;

import javax.swing.JOptionPane;

import POOBanco.TipoConta;
import RevisaoFPOO.Cadastro.Animal;
import RevisaoFPOO.Cadastro.Cachorro;
import RevisaoFPOO.Cadastro.Gato;
import RevisaoFPOO.Cadastro.Outros;

public class App {
    public static void main(String[] args) {
        // criar um array de objetos
        Animal conta[] = new Animal[5];
        // criar e preencher os objetos
        boolean ligado = true;
        int i = 0;
        while (ligado) {

            int acao = Integer.parseInt(JOptionPane.showInputDialog("Escolha a ação desejada:\n"
                    + "1. Cadastro Gato\n"
                    + "2. Cadastro Cachorro\n"
                    + "2. Cadastro outros\n"
                    + "4. Sair\n"));

            switch (acao) {
                case 1:
                    conta[i] = new Gato();// criou objeto
                    conta[i].setNome((JOptionPane.showInputDialog("Digite o Nome")));
                    conta[i].setEspecie((JOptionPane.showInputDialog("Digite a especie")));
                    int pesoGato = Integer
                            .parseInt(JOptionPane.showInputDialog("Digite o peso "));
                    conta[i].setPeso(conta[i].getPeso() + pesoGato);
                    conta[i].setProprietario((JOptionPane.showInputDialog("Digite seu Nome")));

                    JOptionPane.showMessageDialog(null,
                            "O nome do animal é " + conta[i].getNome() + "\n" +
                                    "A espécie do animal é " + conta[i].getEspecie() + "\n" +
                                    "O peso do animal é " + conta[i].getPeso() + "\n" +
                                    "O nome do proprietário " + conta[i].getProprietario() + "\n");
                    i++;
                    break;
                case 2:
                    conta[i] = new Cachorro();// criou objeto
                    conta[i].setNome((JOptionPane.showInputDialog("Digite o Nome")));
                    conta[i].setEspecie((JOptionPane.showInputDialog("Digite a especie")));
                    int pesoCachorro = Integer
                            .parseInt(JOptionPane.showInputDialog("Digite o peso "));
                    conta[i].setPeso(conta[i].getPeso() + pesoCachorro);
                    conta[i].setProprietario((JOptionPane.showInputDialog("Digite seu Nome")));

                    JOptionPane.showMessageDialog(null,
                            "O nome do animal é " + conta[i].getNome() + "\n" +
                                    "A espécie do animal é " + conta[i].getEspecie() + "\n" +
                                    "O peso do animal é " + conta[i].getPeso() + "\n" +
                                    "O nome do proprietário " + conta[i].getProprietario() + "\n");
                    i++;
                    break;
                case 3:
                    conta[i] = new Outros();// criou objeto
                    conta[i].setNome((JOptionPane.showInputDialog("Digite o Nome")));
                    conta[i].setEspecie((JOptionPane.showInputDialog("Digite a especie")));
                    int pesoOutros = Integer
                            .parseInt(JOptionPane.showInputDialog("Digite o peso "));
                    conta[i].setPeso(conta[i].getPeso() + pesoOutros);
                    conta[i].setProprietario((JOptionPane.showInputDialog("Digite seu Nome")));

                    JOptionPane.showMessageDialog(null,
                            "O nome do animal é " + conta[i].getNome() + "\n" +
                                    "A espécie do animal é " + conta[i].getEspecie() + "\n" +
                                    "O peso do animal é " + conta[i].getPeso() + "\n" +
                                    "O nome do proprietário " + conta[i].getProprietario() + "\n");
                    i++;
                break;
                case 4:
                ligado = false;
                break;
            }
        }
    }
}
