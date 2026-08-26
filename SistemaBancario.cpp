#include <iostream>
#include <fstream>
#include <string>

// En un struct, los miembros son públicos por defecto. Cualquier parte del 
// programa puede alterar 'saldo' o 'tipoCuenta' directamente sin validación.
// Este struct no tiene un destructor (~CuentaLegacy), lo que impide que 
// limpie su propia memoria dinámica automáticamente al ser destruido.
struct CuentaLegacy {
    char* titular;
    double saldo;
    int tipoCuenta; // 1: Ahorros, 2: Corriente
    double limiteSobregiro;
};

CuentaLegacy* crearCuenta(const char* nombre, double saldoInicial, int tipo) {
    // Al no haber gestión de ciclo de vida (destructor), se delega peligrosamente 
    // la responsabilidad al cliente de recordar usar 'delete c;'.
    CuentaLegacy* c = new CuentaLegacy();
    
    // Se reserva un arreglo de 50 caracteres con 'new[]'. 
    // Como el struct no se limpia a sí mismo, este bloque quedará huérfano 
    // si el cliente no llama explícitamente a 'delete[] c->titular;'.
    c->titular = new char[50];
    strcpy(c->titular, nombre);
    
    c->saldo = saldoInicial;
    c->tipoCuenta = tipo;
    c->limiteSobregiro = (tipo == 2) ? 500.0 : 0.0;
    
    return c;
}

void procesarRetiro(CuentaLegacy* c, double monto) {
    // El uso de condicionales (if/else) para determinar el comportamiento según 
    // el 'tipoCuenta' obliga a modificar este método si se agregan nuevos productos.
    // En POO, esto debe resolverse con Herencia y Polimorfismo.
    if (c->tipoCuenta == 1 && c->saldo >= monto) {
        c->saldo -= monto;
    } else if (c->tipoCuenta == 2 && (c->saldo + c->limiteSobregiro) >= monto) {
        c->saldo -= monto; // Fuga potencial de lógica y sin registro de auditoría
    }
    // NOTA: No hay liberación de memoria de 'titular' ni de 'c' al terminar el programa
    // Esta función 'procesarRetiro' está separada de los datos que manipula (el struct).
    // En una verdadera arquitectura POO, 'retirar()' debería ser un método 
    // interno de la clase CuentaBancaria para modificar su propio estado.
}
