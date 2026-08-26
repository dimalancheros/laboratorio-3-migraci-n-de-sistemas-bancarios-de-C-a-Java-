public abstract class CuentaBancaria {
    
    private String numeroCuenta;
    private String titular;
    private double saldo;
    
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial >= 0 ? saldoInicial : 0.0; 
    }

    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.println("Depósito exitoso. Nuevo saldo: $" + this.saldo);
        } else {
            System.out.println("El monto a depositar debe ser mayor a cero.");
        }
    }

    public abstract void retirar(double monto);

    public abstract void aplicarComisionMensual();
    
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double nuevoSaldo) {
        this.saldo = nuevoSaldo;
    }
}
