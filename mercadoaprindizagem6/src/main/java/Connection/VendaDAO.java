package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Venda;

public class VendaDAO {
    private Connection connection;
    private List<Venda> Venda;

    public VendaDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS Venda_mercado (nome_cliente VARCHAR(255), valor_total VARCHAR(255), tipos_itens VARCHAR(255))";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    public List<Venda> listarTodos() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Venda = new ArrayList<>();
        try {
            stmt = connection.prepareStatement("SELECT * FROM Venda_mercado");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Venda produto = new Venda(
                        rs.getString("nome_cliente"),
                        rs.getString("valor_total"),
                        rs.getString("tipos_itens"));
                Venda.add(produto);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }
        return Venda;
    }

    public void cadastrar(String nome_cliente, String valor_total, String tipos_itens) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO Venda_mercado (nome_cliente, valor_total, tipos_itens) VALUES (?, ?, ?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome_cliente);
            stmt.setString(2, valor_total);
            stmt.setString(3, tipos_itens);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    public void atualizar(String nome_cliente, String valor_total, String tipos_itens, String novoValor, String condicao) {
        PreparedStatement stmt = null;
        String sql = "UPDATE Venda_mercado SET nome_cliente = ?, valor_total = ?, tipos_itens = ? WHERE " + condicao + " = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome_cliente);
            stmt.setString(2, valor_total);
            stmt.setString(3, tipos_itens);
            stmt.setString(4, novoValor);
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    public void atualizarBanco() {
    }
}
