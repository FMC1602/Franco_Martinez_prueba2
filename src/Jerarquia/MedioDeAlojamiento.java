package Jerarquia;

public abstract class MedioDeAlojamiento {
    protected DatosClientes datosCliente;
    protected double valorBaseNoche;
    protected int cantNoches;
    protected String tipoTemporada;

    public MedioDeAlojamiento(DatosClientes datosCliente, double valorBaseNoche,
                              int cantNoches, String tipoTemporada) {
        this.datosCliente = datosCliente;
        this.valorBaseNoche = valorBaseNoche;
        this.cantNoches = cantNoches;
        this.tipoTemporada = tipoTemporada;
    }

    public DatosClientes getDatosCliente() {
        return datosCliente;
    }

    public void setDatosCliente(DatosClientes datosCliente) {
        this.datosCliente = datosCliente;
    }

    public double getValorBaseNoche() {
        return valorBaseNoche;
    }

    public void setValorBaseNoche(double valorBaseNoche) {
        this.valorBaseNoche = valorBaseNoche;
    }

    public int getCantNoches() {
        return cantNoches;
    }

    public void setCantNoches(int cantNoches) {
        this.cantNoches = cantNoches;
    }

    public String getTipoTemporada() {
        return tipoTemporada;
    }

    public void setTipoTemporada(String tipoTemporada) {
        this.tipoTemporada = tipoTemporada;
    }

    public double subTotal() {
        double subTotal = this.getValorBaseNoche() * this.getCantNoches();
        return subTotal;
    }

    public abstract double adicional();

    public double bonoDescuento() {
        double subtotal = subTotal();
        if (tipoTemporada.equalsIgnoreCase("Baja")) {
            return subtotal * 0.25;
        } else if (tipoTemporada.equalsIgnoreCase("Media")) {
            return subtotal * 12.5/100;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Valor Base por Noche= " + valorBaseNoche + "\n " +
                "Datos del Cliente= " + "(Nombre: " + datosCliente.getNombre() + " " + "Rut: " + datosCliente.getRutCliente() + ")" + "\n " +
                "Temporada='" + tipoTemporada + '\'' + "\n " +
                "Cantidad de Noches=" + cantNoches + '.';
    }

    public double valorACancelar() {
        return subTotal() - bonoDescuento() + adicional();
    }
}
