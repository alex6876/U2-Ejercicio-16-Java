import java.util.List;
import java.util.ArrayList;

public class SalaCine {

    List<Butaca> butacas = new ArrayList<>();

    public void agregarButaca(Butaca butaca) {
        butacas.add(butaca);
    }

    public void bloquearButacas(List<String> codigosButacas) {

        for (String codigo : codigosButacas) {
            boolean encontrada = false;

            for (Butaca butaca : butacas) {
                if (butaca.getCodigo().equals(codigo)) {
                    encontrada = true;

                    if (butaca.getEstado().equals("No disponible")) {
                        System.out.println("La butaca " + codigo + " está ocupada.");
                        return;
                    }

                    break;
                }
            }

            if (!encontrada) {
                System.out.println("La butaca " + codigo + " no existe.");
                return;
            }
        }

        for (String codigo : codigosButacas) {
            for (Butaca butaca : butacas) {
                if (butaca.getCodigo().equals(codigo)) {
                    butaca.setEstado("No disponible");
                    break;
                }
            }
        }

        System.out.println("Reserva realizada correctamente.");
    }

    public void mostrarSala() {
        System.out.println("\nEstado actualizado de la sala:");

        for (Butaca butaca : butacas) {
            System.out.println(
                    butaca.getCodigo() + " - " + butaca.getEstado()
            );
        }
    }
}
