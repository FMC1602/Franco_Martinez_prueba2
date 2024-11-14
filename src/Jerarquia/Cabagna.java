package Jerarquia;

public class Cabagna extends Hospederia{
    protected boolean chimenea;


    public Cabagna(DatosClientes datosCliente, double valorBaseNoche, int cantNoches,
                   String tipoTemporada, int capacidad, boolean esFumador, boolean chimenea) {
        super(datosCliente, valorBaseNoche, cantNoches, tipoTemporada, capacidad, esFumador);
        this.chimenea = chimenea;
    }

    public boolean isChimenea() {
        return chimenea;
    }

    public void setChimenea(boolean chimenea) {
        this.chimenea = chimenea;
    }

    @Override
    public double adicional() {
        return 0;
    }

    public double incrementaValorBase() {
        return (capacidad > 5 ? valorBaseNoche * 18/100 : 0);

    }

}
