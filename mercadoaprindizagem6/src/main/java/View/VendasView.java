package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Connection.ConnectionFactory;
import Connection.VendaDAO;

public class VendasView extends JPanel {
    private JButton cadVenda, adicionar1, procurarButton;
    private JTextField cadCpfField, totalField, totalDescField;
    private DefaultTableModel tableModel;
    private JTable table;
    private JComboBox<String> produtosComboBox;
    private JComboBox<String> precosComboBox;
    private JComboBox<Integer> quantidadeComboBox;
    private JLabel labelResultado, labelPrecoTotal, LabelTotalDesconto;
    private Map<String, Double> mapaProdutos;
    private Map<String, Integer> mapaQuantidades;
    private double valorAcumulado;

    public VendasView() {
        super();
        mapaProdutos = obterDadosDoBanco();
        mapaQuantidades = obterQuantidadesDoBanco();
        valorAcumulado = 0.0;

        setLayout(new GridLayout(6, 2));

        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        cadCpfField = new JTextField("Sem Usuário", 22);
        inputPanel.add(cadCpfField);
        procurarButton = new JButton("Procurar");
        procurarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarUsuarioPorCPF();
            }
        });
        inputPanel.add(procurarButton);

        produtosComboBox = new JComboBox<>(mapaProdutos.keySet().toArray(new String[0]));
        produtosComboBox.addActionListener(e -> {
            atualizarPrecoSelecionado();
            atualizarQuantidadeSelecionado();
            exibirResultado(atualizarPrecoSelecionado());
            configurarQuantidadeComboBox();
        });
        inputPanel.add(produtosComboBox);
        add(inputPanel);

        precosComboBox = new JComboBox<>(mapaProdutos.values().stream().map(String::valueOf).toArray(String[]::new));
        labelResultado = new JLabel("Preço selecionado:");
        // inputPanel.add(precosComboBox);
        inputPanel.add(labelResultado);
        add(inputPanel);

        quantidadeComboBox = new JComboBox<>();
        inputPanel.add(quantidadeComboBox);
        add(inputPanel);

        adicionar1 = new JButton("Adicionar");
        inputPanel.add(adicionar1);
        add(inputPanel);

        // Table Panel
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Item", "Qtd.", "$Un", "Preço Total" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // Submit Panel
        JPanel submitPanel = new JPanel();
        labelPrecoTotal = new JLabel("Preço total");
        submitPanel.add(labelPrecoTotal);
        totalField = new JTextField("Valor total", 17);
        submitPanel.add(totalField);
        LabelTotalDesconto = new JLabel("Desconto total");
        submitPanel.add(LabelTotalDesconto);
        totalDescField = new JTextField("Total Desc.", 17);
        submitPanel.add(totalDescField);
        cadVenda = new JButton("Cadastrar Venda");
        submitPanel.add(cadVenda);
        add(submitPanel);

        adicionar1.addActionListener(e -> {
            adicionarItem();
            calcularTotal();
        });

        cadVenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarVenda();
            }
        });
    }

    private void buscarUsuarioPorCPF() {
        String cpf = cadCpfField.getText();

        if (cpf.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um CPF válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Conectar ao banco de dados
        try (Connection connection = ConnectionFactory.getConnection()) {
            // Consulta SQL para buscar usuário pelo CPF
            String sql = "SELECT nome FROM Cadastro_mercado WHERE codigo = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, cpf);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (cpf != "Sem Usuário") {

                        if (resultSet.next()) {
                            // Usuário encontrado
                            String nome = resultSet.getString("nome");
                            // Exibir o nome do usuário
                            JOptionPane.showMessageDialog(this, "Usuário encontrado: " + nome, "Informação",
                                    JOptionPane.INFORMATION_MESSAGE);
                            // Atualizar o campo de CPF com o nome encontrado
                            cadCpfField.setText(nome);
                            // Acumular o valor
                            String totalText = totalField.getText().replace("R$", "");
                            if (!totalText.equals("Valor total")) {
                                valorAcumulado += Double.parseDouble(totalText);
                            }
                            // Aplicar desconto de 5%
                            double desconto = valorAcumulado * 0.05;
                            totalDescField.setText("R$" + desconto);
                        } else {
                            // Usuário não encontrado
                            JOptionPane.showMessageDialog(this, "Usuário não encontrado.", "Informação",
                                    JOptionPane.INFORMATION_MESSAGE);
                            // Zerar o valor acumulado e o desconto
                            valorAcumulado = 0.0;
                            totalDescField.setText("Total Desc.");
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cadastrarVenda() {
        // Conectar ao banco de dados
        try (Connection connection = ConnectionFactory.getConnection()) {
            // Inserir informações da venda no banco de dados
            String sql = "INSERT INTO Venda_mercado (nome_cliente, valor_total, tipos_itens) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, cadCpfField.getText());
                preparedStatement.setDouble(2, Double.parseDouble(totalField.getText().replace("R$", "")));
                preparedStatement.setInt(3, tableModel.getRowCount());

                // Executar a inserção
                preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(this, "Venda cadastrada com sucesso!", "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);

                // Atualizar o banco de dados após cadastrar a venda
                new VendaDAO().atualizarBanco();

                // Limpar os campos e a tabela após cadastrar a venda
                cadCpfField.setText("Sem Usuário");
                totalField.setText("Valor total");
                totalDescField.setText("Total Desc.");
                tableModel.setRowCount(0);
                valorAcumulado = 0.0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para adicionar item à tabela
    private void adicionarItem() {
        String produtoSelecionado = (String) produtosComboBox.getSelectedItem();
        String quantidadeSelecionado = String.valueOf(quantidadeComboBox.getSelectedItem());
        String preco = labelResultado.getText();

        if (produtoSelecionado != null && quantidadeSelecionado != null && !produtoJaAdicionado(produtoSelecionado)) {
            // Remover "R$" e converter para double
            double precoUnitario = Double.parseDouble(preco.replace("R$", ""));
            double precoTotal = precoUnitario * Integer.parseInt(quantidadeSelecionado);
            tableModel.addRow(new Object[] { produtoSelecionado, quantidadeSelecionado, "R$" + precoUnitario,
                    "R$" + precoTotal });
        } else {
            JOptionPane.showMessageDialog(this,
                    "Selecione um produto válido ou escolha um que ainda não foi adicionado",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para verificar se o produto já foi adicionado à tabela
    private boolean produtoJaAdicionado(String produto) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String produtoTabela = (String) tableModel.getValueAt(i, 0);
            if (produto.equals(produtoTabela)) {
                return true;
            }
        }
        return false;
    }

    // Método para calcular o valor total da tabela
    private void calcularTotal() {
        String cpf = cadCpfField.getText();

        
        double total = 0.0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String totalStr = (String) tableModel.getValueAt(i, 3);
            // Remover "R$" e converter para double
            total += Double.parseDouble(totalStr.replace("R$", ""));
        }
        totalField.setText("R$" + total);
        if (cpf != "Sem Usuário") {
        // Atualizar o desconto com base no novo total
        double desconto = total * 0.05;
        totalDescField.setText("R$" + desconto);
        }
    }

    // Método para obter dados do banco (preços dos produtos)
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

    // Método para obter quantidades do banco
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

    // Método para atualizar o preço selecionado
    private double atualizarPrecoSelecionado() {
        String produtoSelecionado = (String) produtosComboBox.getSelectedItem();
        double preco = 0;
        if (produtoSelecionado != null) {
            preco = mapaProdutos.getOrDefault(produtoSelecionado, 0.0);
            precosComboBox.setSelectedItem("R$" + String.valueOf(preco));
            exibirResultado(preco);
        }
        return preco;
    }

    // Método para atualizar a quantidade selecionada
    private void atualizarQuantidadeSelecionado() {
        String produtoSelecionado = (String) produtosComboBox.getSelectedItem();
        int quantidadeDisponivel = mapaQuantidades.getOrDefault(produtoSelecionado, 0);
        List<Integer> opcoesQuantidade = new ArrayList<>();
        for (int i = 1; i <= quantidadeDisponivel; i++) {
        }
        quantidadeComboBox.setModel(new DefaultComboBoxModel<>(opcoesQuantidade.toArray(new Integer[0])));
    }

    // Método para configurar as opções da JComboBox de quantidade
    private void configurarQuantidadeComboBox() {
        String produtoSelecionado = (String) produtosComboBox.getSelectedItem();
        int quantidadeDisponivel = mapaQuantidades.getOrDefault(produtoSelecionado, 0);
        List<Integer> opcoesQuantidade = new ArrayList<>();
        for (int i = 1; i <= quantidadeDisponivel; i++) {
            opcoesQuantidade.add(i);
        }
        quantidadeComboBox.setModel(new DefaultComboBoxModel<>(opcoesQuantidade.toArray(new Integer[0])));
    }

    // Método para exibir o resultado
    private void exibirResultado(double preco) {
        labelResultado.setText("R$" + preco);
    }
}
