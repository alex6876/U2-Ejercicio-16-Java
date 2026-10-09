public class Butaca {
    String fila;
    int numero;
    String estado;

    public Butaca(String fila, int numero, String estado) {
        this.fila = fila;
        this.numero = numero;
        this.estado = estado;
    }

    public String getCodigo() {
        return fila + numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
