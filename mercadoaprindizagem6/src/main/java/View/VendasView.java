package View;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Connection.CadastroDAO;
import Connection.ProdutosDAO;
import Model.Cadastro;
import Model.Produtos;

public class VendasView extends JPanel {
    JComboBox<String> produtosComboBox;
    JComboBox<String> produtosComboBox1;
    List<Produtos> produtos;
    List<Cadastro> cadastros;
    private JButton cadastrar;

    public VendasView() {
        super();
        produtosComboBox = new JComboBox<>();
        // Preencha o JComboBox com os produtos
        produtos = new ProdutosDAO().listarTodos();
        produtosComboBox.addItem("Selecione o Produto");
        for (Produtos produto : produtos) {
            produtosComboBox.addItem(produto.getMarca()
                    + " " + produto.getNome()
                    + " " + produto.getCodigo());
        }

        add(produtosComboBox);

        JComboBox produtosComboBox1 = new JComboBox<>();
        // Preencha o JComboBox com os produtos
        cadastros = new CadastroDAO().listarTodos();
        produtosComboBox1.addItem("Selecione o Cliente");
        for (Cadastro cadastro : cadastros) {
            produtosComboBox1.addItem(cadastro.getNome()
                    + " " + cadastro.getCpf()
                    + " " + cadastro.getidade());
        }
        add(produtosComboBox1);
        //adiciona o botão cadastrar vendas
        JPanel botoes = new JPanel();
        botoes.add(cadastrar = new JButton("Cadastrar venda"));
        add(botoes);


    }

    public void atualizarComboBox() {
        // Preencha o JComboBox com os produtos
        produtos = new ProdutosDAO().listarTodos();
        produtosComboBox.removeAllItems();
        produtosComboBox.addItem("Selecione o Produto");
        for (Produtos produto : produtos) {
            produtosComboBox.addItem(produto.getMarca()
                    + " " + produto.getNome()
                    + " " + produto.getCodigo());
        }
    }

        public void atualizarComboBox1() {
        // Preencha o JComboBox1 com os produtos
        cadastros = new CadastroDAO().listarTodos();
        produtosComboBox1.removeAllItems();
        produtosComboBox1.addItem("Selecione o produto");
        for (Cadastro produto : cadastros) {
            produtosComboBox.addItem(produto.getNome()
                    + " " + produto.getCpf()
                    + " " + produto.getidade());
        }
    }



}
