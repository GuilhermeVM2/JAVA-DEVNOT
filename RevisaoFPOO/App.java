package RevisaoFPOO;

import javax.swing.JOptionPane;

import POOBanco.TipoConta;
import POOExercicio2.Agenda;
import RevisaoFPOO.Cadastro.Animal;
import RevisaoFPOO.Cadastro.Cachorro;
import RevisaoFPOO.Cadastro.Gato;
import RevisaoFPOO.Cadastro.Outros;
import RevisaoFPOO.Cadastro.agenda;

public class App {

    public static void main(String[] args) {

        // cria o cadastro (Armazenar o vetor)

        agenda agendas[] = new agenda[1000];
        Gato gatos[] = new Gato[10]; // Variável gatos do tipo vetor da classe Gato
        Cachorro cachorros[] = new Cachorro[10]; // Variável cachorros do tipo vetor da classe Cachorro
        Outros outros[] = new Outros[10]; // Variável outros da classe do tipo vetor OutrosAnimais
        int contGatos = 0, contCachorros = 0, contOutros = 0, contAgenda = 0; // Variável do tipo inteira → será um
                                                                              // contador

        // criar a minha aplicação
        JOptionPane.showMessageDialog(null, "Bem-vindo ao Consultório\n do Dr. Frankstein");
        Boolean aberto = true;
        while (aberto) {
            int acao1 = Integer.parseInt(JOptionPane.showInputDialog("1-Cadastro\n 2-Consulta\n 3-Sair"));
            if (acao1 == 1) {// cadastro
                int acao2 = Integer.parseInt(JOptionPane.showInputDialog("1-Gato\n 2-Cachorro\n 3-Outro Animal"));
                if (acao2 == 1) {// cadastro dos gatos
                    gatos[contGatos] = new Gato();// utilizei o construtor
                    gatos[contGatos].setNome(JOptionPane.showInputDialog("Qual o Nome do Gato?"));
                    gatos[contGatos].setEspecie(JOptionPane.showInputDialog("Qual a Especie do Gato?"));
                    gatos[contGatos].setIdade(Integer.parseInt(JOptionPane.showInputDialog("Qual a idade do Gato?")));
                    JOptionPane.showMessageDialog(null,
                            "O nome do animal é " + gatos[contGatos].getNome() + "\n" +
                                    "A espécie do animal é " + gatos[contGatos].getEspecie() + "\n" +
                                    "A idade do animal é " + gatos[contGatos].getIdade());

                    contGatos++;
                }
            } else if (acao1 == 2) {// cadastro
                int acao2 = Integer.parseInt(JOptionPane.showInputDialog("1-Gato\n 2-Cachorro\n 3-Outro Animal"));
                if (acao2 == 1) {// cadastro dos gatos
                    cachorros[contCachorros] = new Cachorro();// utilizei o construtor
                    cachorros[contCachorros].setNome(JOptionPane.showInputDialog("Qual o Nome do Gato?"));
                    cachorros[contCachorros].setEspecie(JOptionPane.showInputDialog("Qual a Especie do Gato?"));
                    cachorros[contCachorros]
                            .setIdade(Integer.parseInt(JOptionPane.showInputDialog("Qual a idade do Gato?")));
                    JOptionPane.showMessageDialog(null,
                            "O nome do animal é " + cachorros[contCachorros].getNome() + "\n" +
                                    "A espécie do animal é " + cachorros[contCachorros].getEspecie() + "\n" +
                                    "A idade do animal é " + cachorros[contCachorros].getIdade());
                    contGatos++;
                }
            }

            else if (acao1 == 3) {// cadastro dos outros
                outros[contOutros] = new Outros();// utilizei o construtor
                outros[contOutros].setNome(JOptionPane.showInputDialog("Qual o Nome do Animal?"));
                outros[contOutros].setEspecie(JOptionPane.showInputDialog("Qual a Especie do Animal?"));
                outros[contOutros].setIdade(Integer.parseInt(JOptionPane.showInputDialog("Qual a idade do Animal?")));
                JOptionPane.showMessageDialog(null,
                        "O nome do animal é " + outros[contOutros].getNome() + "\n" +
                                "A espécie do animal é " + outros[contOutros].getEspecie() + "\n" +
                                "A idade do animal é " + outros[contOutros].getIdade());
                contOutros++;
            }

            else if (acao1 == 2) {// Consulta
                // 1° verificacão - cadastro do nome
                Boolean cadastroOK=false;
                String nomeAgenda = JOptionPane.showInputDialog(null, "Informe o nome do pet");
                for (int i = 0; i < contGatos; i++) {
                    if (gatos[i].getNome().equals(nomeAgenda)) {
                        // mensagem de confirmação
                        JOptionPane.showMessageDialog(null, "Animal encontrado");
                        cadastroOK=true;
                        break;
                    }
                }
                for (int i = 0; i < contCachorros; i++) {
                    if (cachorros[i].getNome().equals(nomeAgenda)) {
                        // mensagem de confirmação
                        JOptionPane.showMessageDialog(null, "Animal encontrado");
                        cadastroOK=true;
                        break;
                    }
                }
                for (int i = 0; i < contOutros; i++) {
                    if (outros[i].getNome().equals(nomeAgenda)) {
                        // mensagem de confirmação
                        JOptionPane.showMessageDialog(null, "Animal encontrado");
                        cadastroOK=true;
                        break;
                    }
                }
                //2° terminal de controle
                if (cadastroOK) {
                    boolean agendar = true;
                    while (agendar) {
                        String diaAgenda = JOptionPane.showInputDialog(null, "informe o dia de agendamento");
                        String horaAgenda = JOptionPane.showInputDialog(null, "informe a hora de agendamento");
                        if(contAgenda==0){
                            agendas[contAgenda] = new agenda();
                            agendas[contAgenda].setDia(diaAgenda);
                            agendas[contAgenda].setHora(horaAgenda);
                            agendar=false;

                        }else{
                        for (int i = 0; i < contAgenda; i++) {
                            if (agendas[i].getDataHora().equals(diaAgenda+horaAgenda)) {
                                //não pode agendar
                                break;
                                }else{
                                agendas[contAgenda] = new agenda();
                                agendas[contAgenda].setDia(diaAgenda);
                                agendas[contAgenda].setHora(horaAgenda);
                                agendar = false;
                                }
                            }

                            
                        }}
                    }
                    
                }


            }
        }
    }

