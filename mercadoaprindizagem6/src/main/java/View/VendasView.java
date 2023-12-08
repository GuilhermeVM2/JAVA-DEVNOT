package View;

import java.util.List;
import java.util.Map;

import javax.swing.table.DefaultTableModel;
import Connection.CadastroDAO;
import Connection.ConnectionFactory;
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

import javax.swing.table.DefaultTableModel;
import Connection.CadastroDAO;
import Connection.ProdutosDAO;
import Model.Produtos;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class VendasView extends JPanel {
    private JButton procurar, adicionar, cadVenda, adicionar1;
    private JTextField cadCpfField, totalField, totalDescField;
    private DefaultTableModel tableModel;
    private JTable table;
    private JComboBox<String> codBarrasBox;
    private int preco;
    List<Produtos> produtos;
    private Map<String, Double> mapaProdutos;
    private Map<String, Integer> mapaQuantidades;
    private JComboBox<String> produtosComboBox;
    private JComboBox<String> precosComboBox;
    private JComboBox<String> quantidadeComboBox;
    private JLabel labelResultado;

    public VendasView() {
        super();
        mapaProdutos = obterDadosDoBanco();
        mapaQuantidades = obterQuantidadesDoBanco();

        // add(new JLabel("Venda de Produto"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        cadCpfField = new JTextField("Digite o CPF", 22);
        inputPanel.add(cadCpfField);
        inputPanel.add(procurar = new JButton("Procurar"));

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // componentes Jcombobox
        produtosComboBox = new JComboBox<>();
        // Preencha o JComboBox com os produtos
        produtos = new ProdutosDAO().listarTodos();
        // Cria a JComboBox de produtos
        produtosComboBox = new JComboBox<>(mapaProdutos.keySet().toArray(new String[0]));
        produtosComboBox.addActionListener(e -> {
            atualizarPrecoSelecionado();
            atualizarQuantidadeSelecionado();
        });
        inputPanel.add(produtosComboBox);
        add(inputPanel);

        // Cria a JComboBox de preços
        precosComboBox = new JComboBox<>(mapaProdutos.values().stream().map(String::valueOf).toArray(String[]::new));

        // Cria o rótulo para exibir o resultado
        labelResultado = new JLabel("Preço selecionado:");
        // Cria o painel e adiciona os componentes

        inputPanel.add(produtosComboBox);
        inputPanel.add(labelResultado);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Cria a JComboBox de Quantidades
        quantidadeComboBox = new JComboBox<>(
                mapaQuantidades.values().stream().map(String::valueOf).toArray(String[]::new));

        // Cria o rótulo para exibir o resultado
        labelResultado = new JLabel("quantidade selecionado:");
        // Cria o painel e adiciona os componentes
        inputPanel.add(quantidadeComboBox);
        add(inputPanel);
        //////////////////////////////////////////////////////////////////
        inputPanel.add(adicionar1 = new JButton("Adicionar"));

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

        adicionar1.addActionListener(e -> {
            adicionarItem();
        });

    }

    // Método para adicionar item à tabela
    private void adicionarItem() {
        String produtoSelecionado = (String) produtosComboBox.getSelectedItem();
        String quantidadeSelecionado = (String) codBarrasBox.getSelectedItem();

        if (!produtoSelecionado.equals("Selecione o Produto") && !quantidadeSelecionado.equals("Quantidade de itens")) {
            tableModel.addRow(new Object[] { produtoSelecionado, quantidadeSelecionado, "", "" });
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto válido ou Quantidade", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    private Map<String, Double> obterDadosDoBanco() {
        Map<String, Double> dadosDoBanco = new HashMap<>();

        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "SELECT nome, preco FROM produtos_mercado";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String nome = resultSet.getString("nome");
                    double preco = resultSet.getDouble("preco");

                    dadosDoBanco.put(nome, preco);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dadosDoBanco;
    }

    private Map<String, Integer> obterQuantidadesDoBanco() {
        Map<String, Integer> dadosDoBanco = new HashMap<>();

        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "SELECT nome, quantidade FROM produtos_mercado";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String nome = resultSet.getString("nome");
                    int quantidade = resultSet.getInt("quantidade");
                    dadosDoBanco.put(nome, quantidade);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dadosDoBanco;
    }

    private void atualizarPrecoSelecionado() {
        String produtoSelecionado = (String) produtosComboBox.getSelectedItem();
        if (produtoSelecionado != null) {
            double preco = mapaProdutos.get(produtoSelecionado);
            precosComboBox.setSelectedItem(String.valueOf(preco));
            exibirResultado(preco);
        }
    }

    private void atualizarQuantidadeSelecionado() {
        String quantidadeSelecionado = (String) quantidadeComboBox.getSelectedItem();
        if (quantidadeSelecionado != null) {
            int quantidade = mapaQuantidades.get(quantidadeSelecionado);
            precosComboBox.setSelectedItem(String.valueOf(quantidade));
            exibirResultado(quantidade);
        }
    }

    private void exibirResultado(double preco) {
        labelResultado.setText("Preço selecionado: R$" + preco);
    }

}