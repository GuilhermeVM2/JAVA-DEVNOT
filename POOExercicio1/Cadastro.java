package POOExercicio1;

public class Cadastro {

    // atributos
    private String nome;
    private double altura;
    private int anodeNascimento;
    private int mesdeNascimento;
    private int diadeNascimento;

    //construtor
    public Cadastro(String nome, double altura, int anodeNascimento, int mesdeNascimento, int diadeNascimento) {
        this.nome = nome;
        this.altura = altura;
        this.anodeNascimento = anodeNascimento;
        this.mesdeNascimento = mesdeNascimento;
        this.diadeNascimento = diadeNascimento;
    }
    
    //construtor vazio
    public Cadastro(){

    }

    // métodos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getAnodeNascimento() {
        return anodeNascimento;
    }

    public void setAnodeNascimento(int anodeNascimento) {
        this.anodeNascimento = anodeNascimento;
    }

    public int getMesdeNascimento() {
        return mesdeNascimento;
    }

    public void setMesdeNascimento(int mesdeNascimento) {
        this.mesdeNascimento = mesdeNascimento;
    }

    public int getDiadeNascimento() {
        return diadeNascimento;
    }

    public void setDiadeNascimento(int diadeNascimento) {
        this.diadeNascimento = diadeNascimento;
    }

    // para imprimir e calcular idade

    public int calcularIdade() {

        int idade;
        if (diadeNascimento <= 29 && mesdeNascimento <= 5) {
            idade = 2023 - anodeNascimento;
        } else {
            idade = 2023 - anodeNascimento - 1;
        }
        return idade;
    }

    public void calcularIdade1() {

        int idade;
        if (diadeNascimento <= 29 && mesdeNascimento <= 5) {
            idade = 2023 - anodeNascimento;
        } else {
            idade = 2023 - anodeNascimento - 1;
        }
        System.out.println("A idade é"+idade);
    }
    public void imprimirInfo() {
        System.out.println("Nome:"+nome);
        System.out.println("Altura é: "+altura+"m");
        System.out.println("Nascimento: "+
                    diadeNascimento+mesdeNascimento+anodeNascimento);
    }

}
