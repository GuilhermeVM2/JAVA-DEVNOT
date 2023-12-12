package Model;

public class Venda {
    // atributos
    private String nome_cliente;
    private String valor_total;
    private String tipos_itens;

    // construtor
    public Venda(String nome_cliente, String valor_total, String tipos_itens) {
        this.nome_cliente = nome_cliente;
        this.valor_total = valor_total;
        this.tipos_itens = tipos_itens;
    }

    // getters and setters
    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getValor_total() {
        return valor_total;
    }

    public void setValor_total(String valor_total) {
        this.valor_total = valor_total;
    }

    public String getTipos_itens() {
        return tipos_itens;
    }

    public void setTipos_itens(String tipos_itens) {
        this.tipos_itens = tipos_itens;
    }
}
