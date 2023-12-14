package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ExemploComboBoxDebitoQuantidade extends JFrame {
    private JComboBox<String> comboBoxProdutos;

    public ExemploComboBoxDebitoQuantidade() {
        // Configurações do banco de dados
        String url = "jdbc:postgresql://localhost:5432/matias";
        String usuario = "postgres";
        String senha = "postgres";

        // SQL para obter os nomes e quantidades dos produtos
        String sql = "SELECT nome, quantidade FROM produtos_mercado";

        try (
            // Conectar ao banco de dados
            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            // Criar uma instrução preparada
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            // Executar a consulta SQL
            ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            // Criar um JComboBox para armazenar os nomes dos produtos
            comboBoxProdutos = new JComboBox<>();

            // Preencher o JComboBox com os nomes dos produtos
            while (resultSet.next()) {
                String nomeProduto = resultSet.getString("nome");
                comboBoxProdutos.addItem(nomeProduto);
            }

            // Adicionar um ActionListener para o JComboBox
            comboBoxProdutos.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Ao selecionar um item, debitar a quantidade no banco de dados
                    debitarQuantidadeDoProduto((String) comboBoxProdutos.getSelectedItem());
                }
            });

            // Adicionar o JComboBox ao JFrame
            add(comboBoxProdutos);

            // Configurações do JFrame
            setTitle("Seleção e Débito de Produtos");
            setSize(300, 150);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);

        } catch (SQLException e) {
            System.err.println("Erro ao obter os nomes dos produtos: " + e.getMessage());
        }
    }

    private void debitarQuantidadeDoProduto(String nomeProduto) {
        // Configurações do banco de dados
        String url = "jdbc:postgresql://localhost:5432/matias";
        String usuario = "postgres";
        String senha = "postgres";

        // SQL para debitar a quantidade do produto selecionado
        String sql = "UPDATE produtos_mercado SET quantidade = quantidade - 1 WHERE nome = ?";

        try (
            // Conectar ao banco de dados
            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            // Criar uma instrução preparada
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        ) {
            // Definir o valor do parâmetro na instrução preparada
            preparedStatement.setString(1, nomeProduto);

            // Executar a instrução SQL
            int linhasAfetadas = preparedStatement.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Quantidade do produto debitada com sucesso!");
            } else {
                System.out.println("Nenhuma quantidade debitada. Verifique o produto selecionado.");
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao debitar a quantidade do produto: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new ExemploComboBoxDebitoQuantidade();
    }
}
