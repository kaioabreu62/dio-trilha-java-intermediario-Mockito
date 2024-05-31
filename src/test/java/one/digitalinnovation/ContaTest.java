package one.digitalinnovation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ContaTest {

    @Spy
    private Conta conta = new Conta(3000);

    @Test
    void verificaSeChamouMetodoDebita() {
        conta.pagaBoleto(300);
        Mockito.verify(conta).debita(300);
    }

    @Test
    void verificaSeNadaFoiChamado() {
        Mockito.verifyNoInteractions(conta);
    }

    @Test
    void verificaAOrdemDasChamadas() {
        InOrder inOrder = Mockito.inOrder(conta);
        conta.pagaBoleto(300);
        conta.validaSaldo(300);
        conta.debita(300);
        conta.enviarCreditoParaEmissor(300);
        inOrder.verify(conta).pagaBoleto(300);
        inOrder.verify(conta).validaSaldo(300);
        inOrder.verify(conta).debita(300);
        inOrder.verify(conta).enviarCreditoParaEmissor(300);
    }

    @Test
    void validaQuantidadeDeVezesQueMetodoFoiChamado() {

        conta.validaSaldo(100);
        conta.validaSaldo(100);
        conta.validaSaldo(100);

        Mockito.verify(conta, Mockito.times(3)).validaSaldo(100);

    }
}
