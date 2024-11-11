package Jerarquia;

public class DatosClientes {
    protected String nombre;
    protected int rutCliente;

    public DatosClientes(String nombre, int rutCliente) {
        this.nombre = nombre;
        this.rutCliente = rutCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(int rutCliente) {
        this.rutCliente = rutCliente;
    }
}
