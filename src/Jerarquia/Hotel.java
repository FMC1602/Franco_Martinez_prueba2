package Jerarquia;

public class Hotel extends Hospederia{
    protected boolean conDesayuno;

    public Hotel(DatosClientes datosCliente, double valorBaseNoche, int cantNoches,
                 String tipoTemporada, int capacidad, boolean esFumador, boolean conDesayuno) {
        super(datosCliente, valorBaseNoche, cantNoches, tipoTemporada, capacidad, esFumador);
        this.conDesayuno = conDesayuno;
    }

    public boolean isConDesayuno() {
        return conDesayuno;
    }

    public void setConDesayuno(boolean conDesayuno) {
        this.conDesayuno = conDesayuno;
    }

    public double adicional() {
        return (esFumador && conDesayuno ? subTotal() * 30 / 100 : -1);
    }
}
