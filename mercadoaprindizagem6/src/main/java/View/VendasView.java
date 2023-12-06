package View;

import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import Connection.CadastroDAO;
import Connection.ProdutosDAO;
import Connection.VendaDAO;
import Controller.VendaControl;
import Model.Cadastro;
import Model.Produtos;
import Model.Venda;
import javafx.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Connection.CadastroDAO;
import Connection.ProdutosDAO;
import Model.Produtos;

public class VendasView extends JPanel {
    private JButton procurar, adicionar, cadVenda;
    private JTextField cadCpfField, totalField, totalDescField;
    private DefaultTableModel tableModel;
    private JTable table;
    private JComboBox<String> codBarrasBox;

    JComboBox<String> produtosComboBox;
    List<Produtos> produtos;

    public VendasView() {
        super();

        // add(new JLabel("Venda de Produto"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        cadCpfField = new JTextField("Digite o CPF", 22);
        inputPanel.add(cadCpfField);
        inputPanel.add(procurar = new JButton("Procurar"));

        // componentes Jcombobox
        produtosComboBox = new JComboBox<>();
        // Preencha o JComboBox com os produtos
        produtos = new ProdutosDAO().listarTodos();
        produtosComboBox.addItem("Selecione o Produto");
        for (Produtos produto : produtos) {
            produtosComboBox.addItem(produto.getNome()
                    + " " + produto.getMarca()
                    + " QTD "
                    + " " + produto.getQuantidade());

        }
        inputPanel.add(produtosComboBox);

        inputPanel.add(adicionar = new JButton("Adicionar"));
        add(inputPanel);

        // componentes Jcombobox
        codBarrasBox = new JComboBox<>();
        codBarrasBox.addItem("Quantidade de itens");
        codBarrasBox.addItem("1");
        codBarrasBox.addItem("2");
        codBarrasBox.addItem("3");
        codBarrasBox.addItem("4");
        codBarrasBox.addItem("5");
        codBarrasBox.addItem("6");
        codBarrasBox.addItem("7");
        codBarrasBox.addItem("8");
        codBarrasBox.addItem("9");
        codBarrasBox.addItem("10");

        inputPanel.add(codBarrasBox);

        inputPanel.add(adicionar = new JButton("Adicionar"));
        add(inputPanel);

        // tabela de compras
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Item", "Qtd.", "$Un", "Preço Total" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        JPanel submitPanel = new JPanel();
        totalField = new JTextField("Valor total", 17);
        submitPanel.add(totalField);
        totalDescField = new JTextField("Total Desc.", 17);
        submitPanel.add(totalDescField);

        submitPanel.add(cadVenda = new JButton("Cadastrar Venda"));

        add(submitPanel);
    }



        // Método para adicionar item à tabela
    private void adicionarItem() {
        String texto = textField.getText();
        if (!texto.isEmpty()) {
            // Adiciona o texto à tabela
            tableModel.addRow(new Object[]{texto});
            // Limpa o campo de texto após adicionar à tabela
            textField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Digite algo no campo de texto", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}