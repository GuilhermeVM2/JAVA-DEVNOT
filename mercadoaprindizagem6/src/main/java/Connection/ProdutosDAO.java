package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Connection.ConnectionFactory;
import Model.Produtos;

/**
 * ProdutosDAO
 */

public class ProdutosDAO {
    // atributo
    private Connection connection;
    private List<Produtos> produtos;

    // construtor
    public ProdutosDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // criar Tabela
    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS produtos_mercado (NOME VARCHAR(255),MARCA VARCHAR(255),QUANTIDADE VARCHAR(255),CODIGO VARCHAR(255) PRIMARY KEY, PRECO DECIMAL)";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Listar todos os produtos cadastrados
    public List<Produtos> listarTodos() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        produtos = new ArrayList<>();
        try {
            stmt = connection.prepareStatement("SELECT * FROM produtos_mercado");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produtos produto = new Produtos(
                        rs.getString("nome"),
                        rs.getString("marca"),
                        rs.getString("quantidade"),
                        rs.getString("codigo"),
                        rs.getDouble("preco"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }
        return produtos;
    }

    // Cadastrar Produto no banco
    public void cadastrar(String nome, String marca, String quantidade, String codigo, double preco) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO produtos_mercado (nome, marca, quantidade, codigo, preco) VALUES (?, ?, ?, ?, ?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, marca);
            stmt.setString(3, quantidade);
            stmt.setString(4, codigo);
            stmt.setDouble(5, preco);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados no banco de dados.");
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Atualizar dados no banco
    public void atualizar(String nome, String marca, String quantidade, String codigo, double preco) {
        PreparedStatement stmt = null;
        String sql = "UPDATE produtos_mercado SET nome = ?, marca = ?, quantidade = ?, preco = ? WHERE codigo = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, marca);
            stmt.setString(3, quantidade);
            stmt.setDouble(4, preco);
            stmt.setString(5, codigo);
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso");
        } catch (SQLException e) {
            // throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar dados no banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Apagar dados do banco
    public void apagar(String codigo) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM produtos_mercado WHERE codigo = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, codigo);
            stmt.executeUpdate();
            System.out.println("Dado apagado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
}
