public class Conta {
    private int numeroConta;
    private int numeroAgencia;
    private String tipoConta;
    private double saldo;
    private Cliente titular;

    public Conta(int numeroConta, int numeroAgencia, String tipoConta, double saldo, Cliente titular) {
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.titular = titular;
    }

    // Lógica para depositar
    public void depositar(double valor){

        // Lança uma exceção caso o valor a ser depositado seja menor ou igual a zero.
        if(valor <= 0) {
            throw new IllegalArgumentException("O valor a ser depositado deve ser positivo.");
        }
        saldo += valor;
    }

    // Lógica para sacar.
    public void sacar(double valor) throws SaldoInsuficienteException {

        // Lança uma exceção caso saque seja menor ou igual a zero.
        if(valor <= 0){
            throw new IllegalArgumentException("O valor do saque deve ser positivo.");
        }

        // Lança uma exceção caso não tenha saldo suficiente.
        if(valor > getSaldo()){
            throw new SaldoInsuficienteException("Saldo insuficiente.");
        }

        saldo -= valor;
    }



    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }
}
