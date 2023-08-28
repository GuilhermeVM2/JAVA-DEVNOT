import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class botao {
       public botao() {
        //criar um janela do tipo frame
        JFrame janela1 = new JFrame("Janela FlowLayout");
        //Chamei o LAyout
        FlowLayout flow = new FlowLayout();
        janela1.setLayout(flow);//atribui o layout
        //criar alguns componentes
        janela1.add(new JButton("Nº de Botões"));
        janela1.add(new JTextField("Insira o Texto", 25));
        JButton enviar = new JButton("Enviar");
        janela1.add(enviar);
        //seta os elementos da Janela
        janela1.setDefaultCloseOperation(1);
        janela1.pack();
        janela1.setVisible(true);
    }
}
