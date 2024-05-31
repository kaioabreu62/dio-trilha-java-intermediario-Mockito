package one.digitalinnovation;

public class Conta {

    private int saldo;

    public Conta(int saldo) {
        this.saldo = saldo;
    }

    public void pagaBoleto(int valorAPagar) {
        validaSaldo(valorAPagar);
        debita(valorAPagar);
        enviarCreditoParaEmissor(valorAPagar);
    }

    public void validaSaldo(int valorAPagar) {
        if (valorAPagar > saldo) {
            throw new IllegalStateException("Saldo insuficiente");
        }
    }

    public void debita(int valorAPagar) {
        this.saldo -= valorAPagar;
    }

    public void enviarCreditoParaEmissor(int valorAPagar) {
        //envia valor para emissor do boleto
    }
}
