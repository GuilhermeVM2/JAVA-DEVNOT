import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class LayoutCalculadoraGUI {
    public LayoutCalculadoraGUI() {
        // construir o Layout da calculadora
        JFrame janelaP = new JFrame("Layout Calculadora");
        JPanel painelb = new JPanel();/// padrão layout
        //set layout do JPanel border
        BorderLayout border = new BorderLayout();
        janelaP.setLayout(border);
         
        // set layout do JPANEL
        janelaP.getContentPane().add(painelb);
        GridLayout grid = new GridLayout(4, 4);
        painelb.setLayout(grid);
        // Vetor com os textos dos botões
        String textbutton[] = { "C", "9", "8", "7", "/", "6", "5", "4", "*", "3", "2", "1", "-", "+", "0", "=" };
        for (int i = 0; i < textbutton.length; i++) {
            painelb.add(new JButton(textbutton[i]));
        }
        //set do Frame
        janelaP.setDefaultCloseOperation(1);
        janelaP.pack();
        janelaP.setVisible(true);
    }

}
