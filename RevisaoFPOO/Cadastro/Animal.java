package RevisaoFPOO.Cadastro;

public abstract class Animal {
    // atributos
    String nome;
    double peso;
    String especie;
    String proprietario;

    int idade;
    // métodos (Podem ser construtores, gets e setter ou métodos próprios)
    // caso o construtor ,que é o método com mesmo nome da classe, não for definido
    // ele será default(Vazio)
    public Animal(String nome, double peso, String especie) {
        this.nome = nome;
        this.peso = peso;
        this.especie = especie;
    }
    // construtor vazio
    public Animal() {
    }
    // sets and gets
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

        public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }


}
