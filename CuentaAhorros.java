public class CuentaAhorros extends CuentaBancaria {
    
    private double tasaInteres;
    private static final double COMISION_FIJA = 15.0; 

    public CuentaAhorros(String numeroCuenta, String titular, double saldoInicial, double tasaInteres) {
        super(numeroCuenta, titular, saldoInicial);
        this.tasaInteres = tasaInteres;
    }

    @Override //no olvidar esto es pa polimorfismo
    public void retirar(double monto) {
        if (monto > 0 && (getSaldo() - monto) >= 0) {
            setSaldo(getSaldo() - monto);
            System.out.println("Retiro exitoso en Cuenta de Ahorros. Nuevo saldo: $" + getSaldo());
        } else {
            System.out.println("Fondos insuficientes o monto inválido. Las cuentas de ahorros no permiten sobregiros.");
        }
    }

    @Override
    public void aplicarComisionMensual() {
        if (getSaldo() >= COMISION_FIJA) {
            setSaldo(getSaldo() - COMISION_FIJA);
            System.out.println("Comisión mensual aplicada. Saldo actual: $" + getSaldo());
        } else {
            System.out.println("Saldo insuficiente para aplicar la comisión de manejo.");
        }
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }
}
