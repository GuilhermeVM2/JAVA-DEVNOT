import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderLayoutExemplo {
    public BorderLayoutExemplo(){
        super();
        JFrame janelaP = new JFrame("Janela Principal");
        //mudando o Layout para o BorderLayout do Frame
        BorderLayout border = new BorderLayout();
        janelaP.setLayout(border);
        janelaP.add(new JButton("West"),BorderLayout.WEST);
        janelaP.add(new JButton("NORTH"),BorderLayout.NORTH);
        janelaP.add(new JButton("EAST"),BorderLayout.EAST);
        janelaP.add(new JButton("CENTER"),BorderLayout.CENTER);
        janelaP.add(new JButton("SOUTH"),BorderLayout.SOUTH);
        //Set Jframe
        janelaP.setDefaultCloseOperation(1);
        janelaP.pack();
        janelaP.setVisible(true);


    }

}
