package Controladora;

import Jerarquia.Cabagna;
import Jerarquia.MedioDeAlojamiento;

import java.util.ArrayList;
import java.util.List;

public class Hospedaje {
    private List<MedioDeAlojamiento> alojamientos;

    public Hospedaje() {
        this.alojamientos = new ArrayList<>();
    }

    

    public boolean agregarAlojamiento(MedioDeAlojamiento alojamiento) { // 1)
        for (MedioDeAlojamiento a : alojamientos) {
            if (a.getDatosCliente().getRutCliente() == alojamiento.getDatosCliente().getRutCliente()) {
                System.out.println("El cliente ya tiene un alojamiento registrado.");
                return false;
            }
        }
        alojamientos.add(alojamiento);
        System.out.println("Alojamiento agregado correctamente.");
        return true;
    }

    public void mostrarAlojamientos() { // 2)
        if (alojamientos.isEmpty()) {
            System.out.println("No hay alojamientos registrados.");
        } else {
            for (MedioDeAlojamiento alojamiento : alojamientos) {
                System.out.println(alojamiento.toString());
            }
        }
    }

    public void mostrarAlojamientoCliente(String rut) { // 3)
        int rutInt = Integer.parseInt(rut); // Cambiamos el nombre a rutInt
        for (MedioDeAlojamiento alojamiento : alojamientos) {
            if (alojamiento.getDatosCliente().getRutCliente() == rutInt) {
                System.out.println("Datos del alojamiento: ");
                System.out.println("El subtotal es: " + alojamiento.subTotal());
                System.out.println("El adicional es: " +alojamiento.adicional());
                System.out.println("El descuento es: " +alojamiento.bonoDescuento());
                System.out.println("El valor es: $" + alojamiento.valorACancelar());
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    public double calcularTotalAdicional() { // 4)
        double total = 0;
        for (MedioDeAlojamiento alojamiento : alojamientos) {
            total += alojamiento.adicional();
            System.out.println(total);
        }
        return total;
    }

    public double calcularTotalBonoDescuento() { // 5)
        double total = 0;
        for (MedioDeAlojamiento alojamiento : alojamientos) {
            total += alojamiento.bonoDescuento();
            System.out.println(total);
        }
        return total;
    }

    public double calcularValorACancelarCliente(String rut) { // 7)
        int rutInt = Integer.parseInt(rut);
        for (MedioDeAlojamiento alojamiento : alojamientos) {
            if (alojamiento.getDatosCliente().getRutCliente() == rutInt) {
                System.out.println("El valor es: $" + alojamiento.valorACancelar());
            }

        }
        System.out.println("Cliente no encontrado.");
        return 0;
    }

    public void aplicarIncrementoValorBase() { // 8)
        for (MedioDeAlojamiento alojamiento : alojamientos) {
            if (alojamiento instanceof Cabagna) {
                Cabagna cabagna = (Cabagna) alojamiento;
                if (cabagna.getCapacidad() > 5) {
                    double nuevoValorBase = cabagna.getValorBaseNoche() * 1.18;
                    cabagna.setValorBaseNoche(nuevoValorBase);
                    System.out.println("Incremento aplicado a la cabaña del cliente " + cabagna.getDatosCliente().getNombre());
                    System.out.println("El nuevo valor es: $" + nuevoValorBase);
                } else {
                    System.out.println("No hay aumento que aplicar");
                }
            }
        }
    }

    public int CantidadAlojamientos() {
        return alojamientos.size();
    }
}