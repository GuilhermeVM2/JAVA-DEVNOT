package Controller;

import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Connection.CarrosDAO;
import Model.Carros;

/**
 * CarrosControl
 */
public class CarrosControl {
    // Atributos
    private List<Carros> carros;
    private DefaultTableModel tableModel;
    private JTable table;

    // Construtor
    public CarrosControl(List<Carros> carros, DefaultTableModel tableModel, JTable table) {
        this.carros = carros;
        this.tableModel = tableModel;
        this.table = table;
    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        carros = new CarrosDAO().listarTodos();
        // Obtém os carros atualizados do banco de dados
        for (Carros carro : carros) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { carro.getMarca(), carro.getModelo(),

                    carro.getAno(), carro.getPlaca(), carro.getValor() });
        }
    }

    // Método para cadastrar um novo carro no banco de dados
    public void cadastrar(String marca, String modelo, String ano, String placa, String valor) {
        new CarrosDAO().cadastrar(marca, modelo, ano, placa, valor);
        // Chama o método de cadastro no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
        JOptionPane.showMessageDialog(null,"Cadastro Realizado com Sucesso");
    }

    // Método para atualizar os dados de um carro no banco de dados
    public void atualizar(String marca, String modelo, String ano, String placa, String valor) {
        new CarrosDAO().atualizar(marca, modelo, ano, placa, valor);
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
        
    }

    // Método para apagar um carro do banco de dados
    public void apagar(String placa) {
        int opcao = JOptionPane.showConfirmDialog(null, "Realmente deseja apagar?", "Confirmação", JOptionPane.YES_NO_OPTION);
        
        if (opcao == JOptionPane.YES_OPTION) {
            // Se o usuário pressionou 'Sim', então apaga
            new CarrosDAO().apagar(placa);
            atualizarTabela(); // Atualiza a tabela de exibição após a exclusão
        } else {
            // Se o usuário pressionou 'Não' ou fechou a caixa de diálogo, não faz nada
        }
    }
}
