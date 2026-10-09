# 🎬 Simulación de Reserva de Butacas de Cine (POO en Java)

Este proyecto es una aplicación en Java que modela el sistema de reservas para una sala de cine. Pone en práctica el uso de colecciones dinámicas (`List` y `ArrayList`), la búsqueda e inspección de objetos en dos fases (para garantizar reservas atómicas) y la interacción entre la plataforma de ventas y la sala de cine en memoria.

---

## 🧩 Clases y Estructura del Sistema

El dominio del problema se compone de 4 clases principales:

*   **`Butaca`**: Modela un asiento individual de la sala.
    *   **Atributos:** `fila`, `numero` y `estado` ("Disponible", "No disponible").
    *   **Métodos principales:** `getCodigo()`, concatena la fila y el número (ej. "A1"); `getEstado()` y `setEstado()` para la lectura y modificación de la disponibilidad.
*   **`SalaCine`**: Administra la colección de asientos dentro del establecimiento.
    *   **Atributos:** Una lista dinámica `List<Butaca>` inicializada como `ArrayList`.
    *   **Métodos principales:**
        *   `agregarButaca()`: Incorpora nuevas instancias de butacas a la lista.
        *   `bloquearButacas(List<String> codigosButacas)`: Ejecuta la validación previa de existencia y disponibilidad antes de cambiar el estado de la lista de asientos.
        *   `mostrarSala()`: Imprime el estado actualizado de cada asiento en la sala.
*   **`PlataformaReserva`**: Intermediario comercial que conecta al cliente con la sala.
    *   **Métodos:** `realizarReserva()`, delega a la `SalaCine` la solicitud de bloqueo para la lista de códigos indicados.
*   **`Main`**: Instancia las butacas de la sala, configura la plataforma y simula una reserva múltiple en lote.

---

## ⚙️ Reglas de Negocio: Verificación en Dos Fases (Transacción Atómica)

Para evitar reservas parciales (por ejemplo, que de 3 asientos pedidos se reserven 2 y falle el tercero), la clase `SalaCine` procesa la solicitud mediante **dos recorridos secuenciales**:

1. **Fase 1 (Validación y Pre-chequeo):**
   * Recorre la lista de códigos solicitados y verifica que **cada uno exista** dentro de la sala.
   * Confirma que ningún asiento de la lista esté marcado como `"No disponible"`.
   * Si alguna de las comprobaciones falla, aborta la operación completa mediante `return` previo a aplicar cambios.
2. **Fase 2 (Efectuación de Reserva):**
   * Si todos los códigos superaron la fase de validación, realiza un segundo recorrido mutando el estado de cada butaca solicitada a `"No disponible"`.

---

## 💻 Salida por Consola

Al ejecutar la clase `Main`, el programa genera el siguiente resultado:

```text
Reserva realizada correctamente.

Estado actualizado de la sala:
A1 - No disponible
A2 - No disponible
A3 - Disponible
B1 - Disponible
B2 - Disponible
