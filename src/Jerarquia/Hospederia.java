package Jerarquia;

public abstract class Hospederia extends MedioDeAlojamiento {
    protected int capacidad;
    protected boolean esFumador;

    public Hospederia(DatosClientes datosCliente, double valorBaseNoche, int cantNoches,
                      String tipoTemporada, int capacidad, boolean esFumador) {
        super(datosCliente, valorBaseNoche, cantNoches, tipoTemporada);
        this.capacidad = capacidad;
        this.esFumador = esFumador;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getValorBaseNoche() {
        return valorBaseNoche;
    }

    public void setValorBaseNoche(int valorBaseNoche) {
        this.valorBaseNoche = valorBaseNoche;
    }

    public int getCantNoches() {
        return cantNoches;
    }

    public void setCantNoches(int cantNoches) {
        this.cantNoches = cantNoches;
    }

    public boolean isEsFumador() {
        return esFumador;
    }

    public void setEsFumador(boolean esFumador) {
        this.esFumador = esFumador;
    }


}
