package Model;

public class Produtos {
    // atributos
    private String nome;
    private String marca;
    private String quantidade;
    private String codigo;
    private Double preco;
    // construtor

    public Produtos(String nome, String marca, String quantidade, String codigo, Double preco) {
        this.nome = nome;
        this.marca = marca;
        this.quantidade = quantidade;
        this.codigo = codigo;
        this.preco = preco;
    }
    // getters and setters

    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
}
