package View;

import javax.swing.*;

import Connection.ConnectionFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuscaUsuarioView extends JFrame {

    private JTextField cpfField;
    private JLabel resultadoLabel;

    public BuscaUsuarioView() {
        setTitle("Buscar Usuário por CPF");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        cpfField = new JTextField("Digite o CPF", 20);
        JButton buscarButton = new JButton("Buscar");
        resultadoLabel = new JLabel();

        panel.add(cpfField);
        panel.add(buscarButton);
        panel.add(resultadoLabel);

        add(panel);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarUsuarioPorCPF();
            }
        });
    }

    private void buscarUsuarioPorCPF() {
        String cpf = cpfField.getText();

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
                    if (resultSet.next()) {
                        // Usuário encontrado
                        String nome = resultSet.getString("nome");
                        resultadoLabel.setText("Usuário encontrado: " + nome);
                        cpfField.setText(nome); // Define o nome no campo de texto
                    } else {
                        // Usuário não encontrado
                        resultadoLabel.setText("Usuário não encontrado.");
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BuscaUsuarioView().setVisible(true);
        });
    }
}
