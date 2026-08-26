El presente informe documenta el proceso de auditoría, análisis de fallas de memoria y refactorización arquitectónica de un sistema bancario simulado. 
El proyecto abarca dos etapas fundamentales: 
la revisión de un diseño legacy en C++ con deficiencias críticas en la gestión manual de memoria y el encapsulamiento, y su posterior reingeniería hacia un paradigma orientado a objetos robusto en Java

Durante la Fase 1, el análisis del código fuente inicial en C++ reveló deficiencias críticas tanto a nivel de seguridad de datos como de gestión de recursos del sistema. 
El uso de asignación dinámica de memoria mediante el operador new sin una liberación simétrica y controlada con delete[] expone al software a la acumulación de basura en el heap.

Para corregir estas fallas, la Fase 2 consistió en el diseño de una jerarquía de clases fuertemente tipada en Java.
Gracias al polimorfismo y a la definición de métodos abstractos, las subclases implementan reglas de negocio diferenciadas: la cuenta de ahorros aplica una política estricta de cero sobregiros y una comisión fija mensual, mientras que la cuenta corriente gestiona un cupo de sobregiro y calcula intereses de mora diarios.

Finalmente, la Fase 3 abordó la gestión segura de recursos para resolver las deficiencias del sistema original mediante la implementación de la interfaz estándar AutoCloseable en la clase de auditoría.
Al adoptar la estructura try-with-resources en la ejecución principal, se eliminan los riesgos de los bloques tradicionales, como los errores de puntero nulo y el enmascaramiento de excepciones de negocio.




