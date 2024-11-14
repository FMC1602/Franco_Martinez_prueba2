package Jerarquia;

public class Carpa extends MedioDeAlojamiento {
    protected int cantidadPersonas;

    public Carpa(DatosClientes datosCliente, double valorBaseNoche, int cantNoches,
                 String tipoTemporada, int cantidadPersonas) {
        super(datosCliente, valorBaseNoche, cantNoches, tipoTemporada);
        this.cantidadPersonas = cantidadPersonas;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    @Override
    public double adicional() {
        return 0;
    }
}
