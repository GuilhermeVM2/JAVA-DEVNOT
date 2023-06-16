package POOBanco;

/**
 * TipoConta
 */
public class TipoConta {
    String nome;
    int NDocumento;
    int opcao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNDocumento() {
        return NDocumento;
    }

    public void setNDocumento(int nDocumento) {
        NDocumento = nDocumento;
    }

    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }
        
}