package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Connection.ConnectionFactory;
import Model.Venda;
import Model.Produtos;

/**
 * VendaDAO
 */
public class VendaDAO {
    // atributo
    private Connection connection;
    private List<Venda> Venda;

    // construtor
    public VendaDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // criar Tabela
    public void criaTabela() {

        // ARRUMAR NOMES DAS TABLES
        String sql = "CREATE TABLE IF NOT EXISTS Venda_mercado (MARCA VARCHAR(255),MODELO VARCHAR(255),ANO VARCHAR(255),PLACA VARCHAR(255) PRIMARY KEY, VALOR VARCHAR(255))";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Listar todas as vendas cadastrados
    public List<Model.Venda> listarTodos() {
        PreparedStatement stmt = null;
        // Declaração do objeto PreparedStatement para executar a consulta
        ResultSet rs = null;
        // Declaração do objeto ResultSet para armazenar os resultados da consulta
        Venda = new ArrayList<>();
        // Cria uma lista para armazenar os Venda recuperados do banco de dados
        try {
            stmt = connection.prepareStatement("SELECT * FROM Venda_mercado");
            // Prepara a consulta SQL para selecionar todos os registros da tabela
            rs = stmt.executeQuery();
            // Executa a consulta e armazena os resultados no ResultSet
            while (rs.next()) {
                // Para cada registro no ResultSet, cria um objeto Venda com as vendas do
                // registro

                Venda produto = new Venda(
                        rs.getString("nome"),
                        rs.getString("marca"),
                        rs.getString("quantidade"),
                        rs.getString("codigo"),
                        rs.getString("preco"));
                Venda.add(produto); // Adiciona o objeto Venda à lista de Venda
            }
        } catch (SQLException ex) {
            System.out.println(ex); // Em caso de erro durante a consulta, imprime o erro
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);

            // Fecha a conexão, o PreparedStatement e o ResultSet
        }
        return Venda; // Retorna a lista de Venda recuperados do banco de dados
    }

    // Cadastrar Carro no banco
    public void cadastrar(String nome, String marca, String quantidade, String codigo, String preco) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para cadastrar na tabela
        String sql = "INSERT INTO Venda_mercado (nome, marca, quantidade, codigo, preco) VALUES (?, ?, ?, ?, ?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, marca);
            stmt.setString(3, quantidade);
            stmt.setString(4, codigo);
            stmt.setString(5, preco);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Atualizar dados no banco
    public void atualizar(String nome, String marca, String quantidade, String codigo, String preco) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para atualizar dados pela codigo
        String sql = "UPDATE Venda_mercado SET nome = ?, marca = ?, quantidade = ?, preco = ? WHERE codigo = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, marca);
            stmt.setString(3, quantidade);
            stmt.setString(4, preco);
            // codigo é chave primaria não pode ser alterada.
            stmt.setString(5, codigo);
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Apagar dados do banco
    public void apagar(String codigo) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para apagar dados pela codigo
        String sql = "DELETE FROM Venda_mercado WHERE codigo = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, codigo);
            stmt.executeUpdate(); // Executa a instrução SQL
            System.out.println("Dado apagado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

        // Buscar Venda por CPF
        public Model.Venda buscarPorCPF(String cpf) {
            PreparedStatement stmt = null;
            ResultSet rs = null;
            Model.Venda venda = null;
            try {
                String sql = "SELECT * FROM Venda_mercado WHERE cpf = ?";
                stmt = connection.prepareStatement(sql);
                stmt.setString(1, cpf);
                rs = stmt.executeQuery();
    
                if (rs.next()) {
                    venda = new Model.Venda(
                            rs.getString("nome"),
                            rs.getString("marca"),
                            rs.getString("quantidade"),
                            rs.getString("codigo"),
                            rs.getString("preco"));
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectionFactory.closeConnection(connection, stmt, rs);
            }
            return venda;
        }

    
}