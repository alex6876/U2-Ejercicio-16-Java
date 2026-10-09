import java.util.List;

public class PlataformaReserva {

    SalaCine sala;

    public PlataformaReserva(SalaCine sala) {
        this.sala = sala;
    }

    public void realizarReserva(List<String> codigosButacas) {
        sala.bloquearButacas(codigosButacas);
    }
}
