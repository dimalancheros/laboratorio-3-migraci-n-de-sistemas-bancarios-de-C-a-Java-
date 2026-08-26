public class CuentaCorriente extends CuentaBancaria {
    
    private double cupoSobregiro;
    private static final double TASA_INTERES_MORA_DIARIA = 0.005;

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial, double cupoSobregiro) {
        super(numeroCuenta, titular, saldoInicial);
        this.cupoSobregiro = cupoSobregiro;
    }

    @Override
    public void retirar(double monto) {
        if (monto > 0 && (getSaldo() + cupoSobregiro) >= monto) {
            setSaldo(getSaldo() - monto);
            if (getSaldo() < 0) {
                System.out.println("Retiro exitoso. La cuenta ha entrado en sobregiro. Saldo actual: $" + getSaldo());
            } else {
                System.out.println("Retiro exitoso en Cuenta Corriente. Nuevo saldo: $" + getSaldo());
            }
        } else {
            System.out.println("Monto supera el saldo disponible y el cupo de sobregiro autorizado.");
        }
    }

    @Override
    public void aplicarComisionMensual() {
        if (getSaldo() < 0) {
            double mora = Math.abs(getSaldo()) * TASA_INTERES_MORA_DIARIA * 30;
            setSaldo(getSaldo() - mora);
            System.out.println("Comisión de sobregiro e intereses de mora aplicados. Saldo actual: $" + getSaldo());
        } else {
            System.out.println("Cuenta corriente sin sobregiro. No se aplican cargos por mora este mes.");
        }
    }

    public double getCupoSobregiro() {
        return cupoSobregiro;
    }

    public void setCupoSobregiro(double cupoSobregiro) {
        this.cupoSobregiro = cupoSobregiro;
    }
}
