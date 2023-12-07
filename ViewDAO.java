package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Connection.ConnectionFactory;
import Model.Venda;
import Model.Produtos;

/**
 * ViewDAO
 */
public class ViewDAO {
    // atributo
    private Connection connection;
    private String cadCpfField;
    // construtor
    public ViewDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void pesquisarNoBanco() {

        String sql = "SELECT * FROM cadastro_mercado WHERE codigo = ?";

        try (
                Statement stmt = this.connection.createStatement();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, cadCpfField);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "foda");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente ainda não cadastrado... :(");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar no banco de dados.");
        }

    }
}