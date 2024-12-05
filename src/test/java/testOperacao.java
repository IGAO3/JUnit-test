import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testOperacao {

    private Cliente cliente;
    private Conta conta;

    @BeforeEach
    void setUp() {
        cliente = new Cliente(1, "Luffy", "luffy@chapeudepalha.com", 19);
        conta = new Conta(1020, 01, "Corrente", 5500, cliente);
    }

    @Test
    void testDeposito(){
        conta.depositar(2000);
        Assertions.assertEquals(7500, conta.getSaldo());
    }

    @Test
    void testSacar(){
        conta.sacar(3000);
        Assertions.assertEquals(2500, conta.getSaldo());
    }

    @Test
    void testSaqueMaiorQueSaldo(){
        SaldoInsuficienteException exception = Assertions.assertThrows(SaldoInsuficienteException.class, () -> {
            conta.sacar(6000);
        });
        Assertions.assertEquals("Saldo insuficiente.", exception.getMessage());
    }

    @Test
    void testDepositarValorZero(){
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            conta.depositar(0);
        });
        Assertions.assertEquals("O valor a ser depositado deve ser positivo.", exception.getMessage());
    }
}
