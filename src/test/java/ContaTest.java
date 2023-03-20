import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.SourceType;

import java.sql.SQLOutput;

public class ContaTest {

    private double deposito1;
    private double deposito2;
    private double sacar1;
    private double sacar2;

    @BeforeEach
    public void insertsTest() {
        deposito1 = 200.0;
        deposito2 = 500.0;
        sacar1 = 50.0;
        sacar2 = 1000.0;
    }

    @Test
    public void contaDepositoTest() {
        Conta conta = new Conta();

        double sld = deposito1 + deposito2;

        conta.depositarValor(deposito1);
        conta.depositarValor(deposito2);

        Assertions.assertEquals(sld, conta.getSaldo());
    }

    @Test
    public void contaSacarTest() throws SaldoInsuficienteException {
        Conta conta = new Conta();

        double sld = deposito1 - sacar1;

        conta.depositarValor(deposito1);
        conta.sacarValor(sacar1);

        Assertions.assertEquals(sld, conta.getSaldo());
    }

    @Test
    public void saldoInsuficienteTest() {
        Conta conta = new Conta();

        conta.depositarValor(deposito1);

        Throwable throwable = Assertions.assertThrows(SaldoInsuficienteException.class, () ->
            conta.sacarValor(sacar2)
        );

        Assertions.assertEquals("Saldo Insuficiente\n", throwable.getMessage());
    }

}
