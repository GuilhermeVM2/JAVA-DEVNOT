package View;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class JanelaPrincipal extends JFrame {
    // criação do tabbedPane para incluir as tabs
    private JTabbedPane jTPane;
    
    public JanelaPrincipal() {
        jTPane = new JTabbedPane();
        add(jTPane);
        // criandos as tabs
        // tab1 produtos
        ProdutosPainel tab1 = new ProdutosPainel();
        CadastroPainel tab2 = new CadastroPainel();
        VendasView tab3 = new VendasView();
        VendaPainel tab4 = new VendaPainel();
        jTPane.add("Produtos", tab1);
        jTPane.add("Cadastro", tab2);
        jTPane.add("Vendas", tab3);
        jTPane.add("Vendas Feitas", tab4);

        setBounds(100, 100, 700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jTPane.addChangeListener(e->{
            tab4.atualizarTabela();
        });

        jTPane.addChangeListener(e->{
            tab1.atualizarTabela();
        });



    }

    // métodos para tornar a janela visível
    public void run() {
        this.setVisible(true);
    }
}