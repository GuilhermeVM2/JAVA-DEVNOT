package POOBanco;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        // criar um array de objetos
        TipoConta conta[] = new TipoConta[5];
        // criar e preencher os objetos
        boolean ligado = true;
        int i = 0;
        while (ligado) {

            int atuacao = Integer.parseInt(JOptionPane.showInputDialog("Escolha a ação desejada:\n"
                    + "1. Criar Conta\n"
                    + "2. Acessar Conta\n"
                    + "3. Sair\n"));

            switch (atuacao) {
                case 1:
                    int opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha a ação desejada:\n"

                            + "1. Pessoa Física\n"
                            + "2. Pessoa Jurídica\n"
                            + "3. Sair\n"));

                    if (opcao == 1) {
                        conta[i] = new TipoConta();// criou objeto
                        // set os atributos do objeto
                        conta[i].setnDocumento(
                                Integer.parseInt(JOptionPane.showInputDialog("Digite seu N° CPF (Somente números)")));
                        conta[i].setNome((JOptionPane.showInputDialog("Digite seu N° Nome")));
                        conta[i].setnConta(i);
                        JOptionPane.showMessageDialog(null,
                                "Parabéns " + conta[i].getNome() + "\n Conta pessoa física criada  com Sucesso");
                        JOptionPane.showMessageDialog(null, "Seu número de conta é " + conta[i].getnConta());

                    } else if (opcao == 2) {
                        conta[i] = new TipoConta();// criou objeto
                        // set os atributos do objeto
                        conta[i].setnDocumento(
                                Integer.parseInt(JOptionPane.showInputDialog("Digite seu N° CNPJ (Somente números)")));
                        conta[i].setNome((JOptionPane.showInputDialog("Digite sua Razão social")));
                        conta[i].setnConta(i);
                        JOptionPane.showMessageDialog(null,
                                "Parabéns " + conta[i].getNome() + "\n Conta pessoa jurídica criada  com Sucesso");
                        JOptionPane.showMessageDialog(null, "Seu número de conta é " + conta[i].getnConta());
                    }
                    i++;
                    break;
                case 2:
                    int acesso = Integer.parseInt(JOptionPane.showInputDialog("Digite seu N° de conta"));
                    // validade
                    if (acesso >= 0 && acesso < i) {
                        JOptionPane.showMessageDialog(null, "Bem vindo " + conta[acesso].getNome());
                        boolean ligado2 = true;
                        while(ligado2){
                        int escolha = Integer.parseInt(JOptionPane.showInputDialog("Escolha a ação desejada:\n"

                                + "1. Saldo\n"
                                + "2. Empréstimo\n"
                                + "3. Saque\n"
                                + "4. Depositar\n"
                                + "5. Sair"));

                        switch (escolha) {
                            case 1:
                                JOptionPane.showMessageDialog(null, "Seu saldo é "+conta[acesso].getSaldo()); 
                                break;

                            case 2:
                                

                                
                                if (conta[acesso].getSaldo() < 100) {
                                    JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                                }
                                else {
                                    int emprestar = Integer.parseInt(JOptionPane.showInputDialog("Seu limite de empréstimo é " + conta[acesso].emprestimo()));
                                    conta[acesso].setSaldo(conta[acesso].getSaldo() + emprestar);
                                    JOptionPane.showMessageDialog(null,
                                            "Seu saldo atual é " + conta[acesso].getSaldo());
                                }
                                break;

                            case 3:
                                int sacar = Integer.parseInt(JOptionPane
                                        .showInputDialog("Seu limite de saque é " + conta[acesso].getSaldo()));
                                if (sacar >= conta[acesso].getSaldo()) {
                                    JOptionPane.showMessageDialog(null,
                                            "Saldo Insuficiente");
                                }
                                else {
                                        conta[acesso].setSaldo(conta[acesso].getSaldo() - sacar);
                                    JOptionPane.showMessageDialog(null,
                                            "Seu saldo atual é " + conta[acesso].getSaldo());
                                }
                            

                                break;
                            case 4:
                                int depositar = Integer
                                        .parseInt(JOptionPane.showInputDialog("Escreva o valor de depósito "));
                                conta[acesso].setSaldo(conta[acesso].getSaldo() + depositar);
                                JOptionPane.showMessageDialog(null, "Seu saldo atual é " + conta[acesso].getSaldo());
                                break;

                            case 5:
                                ligado2 = false;
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Digite uma opção de número correta");
                                break;
                        }

                    }
                }

                    break;
                case 3:
                    ligado = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Digite uma opção de número correta");
                    break;
            }
        }
    }

}
