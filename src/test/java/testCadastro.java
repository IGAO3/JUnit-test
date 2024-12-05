import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class testCadastro {

    private Cliente cliente;
    private Conta conta;

    @BeforeEach
    void setUp(){
        cliente = new Cliente(1, "Luffy", "luffy@chapeudepalha.com", 19);
        conta = new Conta(1020, 01, "Corrente", 5500, cliente);
    }

    @Test
    void testCriarCliente(){
        Assertions.assertEquals(1, cliente.getId());
        Assertions.assertEquals("Luffy", cliente.getNome());
        Assertions.assertEquals("luffy@chapeudepalha.com", cliente.getEmail());
        Assertions.assertEquals(19, cliente.getIdade());
    }

    @Test
    void testCriarConta(){
        Assertions.assertEquals(1020, conta.getNumeroConta());
        Assertions.assertEquals(01, conta.getNumeroAgencia());
        Assertions.assertEquals("Corrente", conta.getTipoConta());
        Assertions.assertEquals(5500, conta.getSaldo());
        Assertions.assertEquals(cliente, conta.getTitular());
    }

    /* A classe abaixo é utilizada para transformar a saida string em array de bytes,
    mostrando que obtive a saída correta, mas sem exibir ela. */
    @Test
    void testIdentificarClientePorId(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        cliente.identificarCliente();

        Assertions.assertEquals("Cliente identificado", outputStream.toString().trim());
    }

}
