public class Conta {

    public double saldo;

    public Conta() {
        this.saldo = 0;
    }

    public void depositarValor(double valor) {
        this.saldo += valor;
    }

    public void sacarValor(double valor) throws SaldoInsuficienteException {
        if(this.saldo >= valor) {
            this.saldo -= valor;
        } else {
            throw new SaldoInsuficienteException("Saldo Insuficiente\n");
        }

    }

    public double getSaldo() {
        return this.saldo;
    }

    public boolean getPositive() {
        boolean isPositive = this.saldo > 0;
        return isPositive;
    }

}
