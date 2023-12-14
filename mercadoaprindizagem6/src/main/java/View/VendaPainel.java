package View;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.VendaDAO;
import Controller.VendaControl;
import Model.Venda;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VendaPainel extends JPanel {
    // Atributos(componentes)
    private JButton atualizar, apagar, editar, registrar;
    private List<Venda> vendas;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    // Construtor(GUI-JPanel)
    public VendaPainel() {
        super();

        // entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Prezado(a) Funcionário"));
        add(new JLabel("Lembramos que as informações no banco de dados são apenas para consulta."));
        add(new JLabel("Por favor, evite realizar alterações."));
        add(new JLabel("Qualquer dúvida, entre em contato."));
        add(new JLabel("Atenciosamente"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        add(inputPanel);

        // tabela de Venda
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Nome Cliente", "Valor Total", "Tipos Itens" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // criar o banco de dados
        new VendaDAO().criaTabela();
        // executar o método de atualizar tabela
        atualizarTabela();

        // tratamento de eventos
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    // se o valor da primeira linha for texto seta dentro do BD
                    // Exemplo: cadNomeField.setText((String) table.getValueAt(linhaSelecionada, 0));
                }
            }
        });

        VendaControl operacoes = new VendaControl(vendas, tableModel, table);

        // tratamento para o botão atualizar
    }

    // métodos(Atualizar tabela)
    // Método para atualizar a tabela de exibição com dados do banco de dados
    public void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        vendas = new VendaDAO().listarTodos();
        // Obtém os Venda atualizados do banco de dados
        for (Venda venda : vendas) {
            // Adiciona os dados de cada venda como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { venda.getNome_cliente(), venda.getValor_total(),
                    venda.getTipos_itens() });
        }
    }
}
