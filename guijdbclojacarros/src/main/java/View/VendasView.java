package View;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Connection.CadastroDAO;
import Controller.CarrosDAO;
import Model.Cadastro;
import Model.Carros;

public class VendasView extends JPanel {
    JComboBox<String> carrosComboBox;
    JComboBox<String> carrosComboBox1;
    List<Carros> carros;
    List<Cadastro> cadastros;
    private JButton cadastrar;

    public VendasView() {
        super();
        carrosComboBox = new JComboBox<>();
        // Preencha o JComboBox com os carros
        carros = new CarrosDAO().listarTodos();
        carrosComboBox.addItem("Selecione o Carro");
        for (Carros carro : carros) {
            carrosComboBox.addItem(carro.getMarca()
                    + " " + carro.getModelo()
                    + " " + carro.getPlaca());
        }

        add(carrosComboBox);

        JComboBox carrosComboBox1 = new JComboBox<>();
        // Preencha o JComboBox com os carros
        cadastros = new CadastroDAO().listarTodos();
        carrosComboBox1.addItem("Selecione o Cliente");
        for (Cadastro cadastro : cadastros) {
            carrosComboBox1.addItem(cadastro.getNome()
                    + " " + cadastro.getCpf()
                    + " " + cadastro.getidade());
        }
        add(carrosComboBox1);
        //adiciona o botão cadastrar vendas
        JPanel botoes = new JPanel();
        botoes.add(cadastrar = new JButton("Cadastrar venda"));
        add(botoes);


    }

    public void atualizarComboBox() {
        // Preencha o JComboBox com os carros
        carros = new CarrosDAO().listarTodos();
        carrosComboBox.removeAllItems();
        carrosComboBox.addItem("Selecione o Carro");
        for (Carros carro : carros) {
            carrosComboBox.addItem(carro.getMarca()
                    + " " + carro.getModelo()
                    + " " + carro.getPlaca());
        }
    }

        public void atualizarComboBox1() {
        // Preencha o JComboBox1 com os carros
        cadastros = new CadastroDAO().listarTodos();
        carrosComboBox1.removeAllItems();
        carrosComboBox1.addItem("Selecione o Carro");
        for (Cadastro carro : cadastros) {
            carrosComboBox.addItem(carro.getNome()
                    + " " + carro.getCpf()
                    + " " + carro.getidade());
        }
    }



}
