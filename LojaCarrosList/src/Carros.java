import javax.swing.JOptionPane;

public class Carros {
    //Atributos
    String marca;
    String modelo;
    String ano;
    String cor;
    //Métodos
    //Construtor Cheio
    public Carros(String marca, String modelo, String ano, String cor) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
    }
    //Construtor Vazio
    public Carros() {
    }
    //Métodos padrões (Getter and Setters)
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    //método própio para impressão
    public String ImprimirLN(){//Listar
        String imprimir = marca+" "+modelo+" "+" "+ano+" "+cor+"\n";
        return imprimir;
    }
    public void imprimir(){//Consultar
        JOptionPane.showMessageDialog(null,marca+"\n"+modelo+"\n"+ano+"\n"+cor);
    }
    
    
}
