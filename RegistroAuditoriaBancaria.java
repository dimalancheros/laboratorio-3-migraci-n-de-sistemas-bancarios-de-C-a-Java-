public class RegistroAuditoriaBancaria implements AutoCloseable {

    private String idRegistro;

    public RegistroAuditoriaBancaria(String idRegistro) {
        this.idRegistro = idRegistro;
        System.out.println("Abriendo recurso de log para el registro: " + this.idRegistro);
    }

    public void registrarEvento(String mensaje) {
        System.out.println("[LOG - " + idRegistro + "]: " + mensaje);
    }

    @Override
    public void close() {
        System.out.println("Cerrando y liberando recurso de forma segura para el registro: " + this.idRegistro);
    }
}
