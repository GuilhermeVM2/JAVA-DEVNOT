package Controller;

import java.util.List;
import javax.swing.JTable;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Connection.VendaDAO;
import Model.Venda;

/**
 * VendaControl
 */
public class VendaControl {
    // Atributos
    private List<Venda> Venda;
    private DefaultTableModel tableModel;
    private JTable table;

    // Construtor
    public VendaControl(List<Venda> Venda, DefaultTableModel tableModel, JTable table) {
        this.Venda = Venda;
        this.tableModel = tableModel;
        this.table = table;
    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        Venda = new VendaDAO().listarTodos();
        // Obtém os Venda atualizados do banco de dados
        for (Venda venda : Venda) {
            // Adiciona os dados de cada venda como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { venda.getNome_cliente(), venda.getTipos_itens(), venda.getValor_total() });
            atualizarTabela();
        }
    }


    // Método para atualizar os dados de um venda no banco de dados
    public void atualizar(String marca, String modelo, String ano, String placa, String valor) {
        new VendaDAO().atualizar(marca, modelo, ano, placa, valor);
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
    }

}
