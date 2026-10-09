import java.util.List;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        SalaCine sala = new SalaCine();

        sala.agregarButaca(new Butaca("A", 1, "Disponible"));
        sala.agregarButaca(new Butaca("A", 2, "Disponible"));
        sala.agregarButaca(new Butaca("A", 3, "Disponible"));
        sala.agregarButaca(new Butaca("B", 1, "Disponible"));
        sala.agregarButaca(new Butaca("B", 2, "Disponible"));

        PlataformaReserva plataforma = new PlataformaReserva(sala);

        List<String> codigos = Arrays.asList("A1", "A2");

        plataforma.realizarReserva(codigos);

        sala.mostrarSala();
    }
}
