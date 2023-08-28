import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.Frame;

public class Container extends JFrame {
    private int cont =1;
    
    // public Container(){
    // this.setBounds(50, 100, 400, 150);
    // this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    // FlowLayout flow = new FlowLayout();//Define o layout do container
    // this.setLayout(flow);//seta layout do container
    // for (int i = 0; i <=cont ; i++) {
    // this.add(new JButton("Aperte"+i));//Adiciona um botão
    // this.setVisible(true);//Exibe a janela
    // }
    // }


    public Container(){
    this.setBounds(50, 100, 400, 150);
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    FlowLayout flow = new FlowLayout();//Define o layout do container
    this.setLayout(flow);//seta layout do container
    JButton but = new JButton("I am a Swing button");
    JPanel painel = new JPanel();
    painel.add(but);
    for (int i = 0; i <=cont ; i++) {
    this.add(new JButton("Aperte"+i));//Adiciona um botão
    this.setVisible(true);//Exibe a janela
    but.addActionListener(e ->{
        painel.add(new JButton("Aperte"+cont));//Adiciona um botão
    });
    }
    }

    // public Container(){
    // this.setBounds(200, 200, 400, 150);
    // this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    // FlowLayout flow = new FlowLayout();
    // JLabel label = new JLabel("Texto");
    // }
}
