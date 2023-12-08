package View;

import javax.swing.*;
import Connection.ConnectionFactory; // Importa a classe ConnectionFactory para estabelecer a conexão com o banco de dados
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ExemploComboBoxComBanco {

    private Map<String, Double> mapaProdutos; // Mapa para armazenar dados do banco (nome do produto e preço)

    private JComboBox<String> comboBox; // JComboBox para exibir os itens disponíveis
    private JLabel labelResultado; // JLabel para exibir o resultado (preço selecionado)

    // Construtor da classe
    public ExemploComboBoxComBanco() {
        // Inicializa o mapa de nomes e preços a partir do banco de dados
        mapaProdutos = obterDadosDoBanco();

        // Cria a interface gráfica
        criarGUI();
    }

    // Método para obter dados do banco de dados
    private Map<String, Double> obterDadosDoBanco() {
        Map<String, Double> dadosDoBanco = new HashMap<>(); // Cria um mapa para armazenar os dados

        // Tenta estabelecer a conexão com o banco de dados
        try (Connection connection = ConnectionFactory.getConnection()) {
            // Define a consulta SQL para obter nome e preço dos produtos
            String sql = "SELECT nome, preco FROM produtos_mercado";
            
            // Tenta executar a consulta preparada
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                // Itera sobre os resultados da consulta
                while (resultSet.next()) {
                    String nome = resultSet.getString("nome"); // Obtém o nome do produto
                    double preco = resultSet.getDouble("preco"); // Obtém o preço do produto
                    dadosDoBanco.put(nome, preco); // Adiciona ao mapa
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime detalhes do erro em caso de falha na conexão ou consulta
        }

        return dadosDoBanco; // Retorna o mapa de dados do banco
    }

    // Método para criar a interface gráfica
    private void criarGUI() {
        JFrame frame = new JFrame("Exemplo JComboBox com Banco de Dados"); // Cria um JFrame

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura a operação padrão de fechamento

        // Cria a JComboBox e adiciona um ouvinte de ação para atualizar o resultado
        comboBox = new JComboBox<>(mapaProdutos.keySet().toArray(new String[0]));
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Atualiza o valor do preço ao selecionar um item
                String itemSelecionado = (String) comboBox.getSelectedItem();
                if (itemSelecionado != null) {
                    double preco = mapaProdutos.get(itemSelecionado);
                    exibirResultado(preco);
                }
            }
        });

        // Cria o rótulo para exibir o resultado
        labelResultado = new JLabel("Preço selecionado:");

        // Cria o painel e adiciona os componentes
        JPanel panel = new JPanel();
        panel.add(comboBox);
        panel.add(labelResultado);

        // Adiciona o painel ao frame
        frame.getContentPane().add(panel);

        // Configurações do frame
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null); // Centraliza a janela na tela
        frame.setVisible(true); // Torna a janela visível
    }

    // Método para exibir o resultado
    private void exibirResultado(double preco) {
        labelResultado.setText("Preço selecionado: R$" + preco);
    }

    // Método principal para iniciar o aplicativo
    public static void main(String[] args) {
        // Executa o aplicativo na thread de despacho de eventos Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ExemploComboBoxComBanco(); // Cria uma instância da classe principal
            }
        });
    }
}
