package POOBanco;

import javax.swing.JOptionPane;

/**
 * TipoConta
 */
public class TipoConta {
    String nome;
    int nDocumento;
    int opcao;
    int nConta;

    // caso 2 
    double saldo;
    double emprestimo;
    double saque;
    double depositar;
    
        //caso 1
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getnConta() {
        return nConta;
    }

    public void setnConta(int nConta) {
        this.nConta = nConta;
    }

    public int getnDocumento() {
        return nDocumento;
    }

    public void setnDocumento(int nDocumento) {
        nDocumento = nDocumento;
    }

    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    // caso 2 
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public double emprestimo() {
        if (saldo>=100) {
            emprestimo = saldo*2;
        }
        else{
            JOptionPane.showMessageDialog(null,"Imprestimo não poderá ser feito\n"+"Saldo insuficiente");
        }
        return emprestimo;
    }

    public double getSaque() {
        return saque;
    }

    public void setSaque(double saque) {
        this.saque = saque;
    }

    public double getDepositar() {
        return depositar;
    }

    public void setDepositar(double depositar) {
        this.depositar = depositar;
    }


        
}