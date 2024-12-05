public class Operacoes {
    public static void main(String[] args){

        Cliente cliente1 = new Cliente(1, "Luffy", "luffy@capitao.com.br", 19);
        Cliente cliente2 = new Cliente(2, "Zoro", "zoro@imediato.com.br", 21);
        Cliente cliente3 = new Cliente(3, "Sanji", "luffy@cozinheiro.com.br", 21);

        Conta conta1 = new Conta(1010, 31, "Corrente", 7000, cliente1);
        Conta conta2 = new Conta(2020, 31, "Corrente", 5000, cliente2);
        Conta conta3 = new Conta(3030, 31, "Corrente", 4000, cliente3);

        try{
            conta1.sacar(5000);
        }catch(SaldoInsuficienteException e){
            System.out.println("Erro na transação: " + e.getMessage());
        }

        try{
            conta1.depositar(2000);
        }catch(IllegalArgumentException e){
            System.out.println("Erro na transação: " + e.getMessage());
        }

        System.out.println("Saldo atual: " + conta1.getSaldo());
    }
}
