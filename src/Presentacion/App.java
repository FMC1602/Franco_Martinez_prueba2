package Presentacion;

import Controladora.Hospedaje;
import Jerarquia.Carpa;
import Jerarquia.DatosClientes;
import Jerarquia.Hotel;
import Jerarquia.Cabagna;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        App app = new App();
        app.iniciar();
    }

    private Hospedaje controlador;
    private Scanner scanner;

    public App() {
        this.controlador = new Hospedaje();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menú de Gestión de Alojamientos ---");
            System.out.println("1. Agregar Alojamiento");
            System.out.println("2. Mostrar Alojamientos");
            System.out.println("3. Mostrar Alojamiento de un Cliente");
            System.out.println("4. Calcular Total Adicional");
            System.out.println("5. Calcular Total Bono Descuento");
            System.out.println("6. Cantidad de medios de alojamiento");
            System.out.println("7. Calcular Valor a Cancelar por un Cliente");
            System.out.println("8. Aplicar Incremento en Valor Base");
            System.out.println("9. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el tipo de alojamiento (Hotel, Cabaña o Carpa): ");
                    String tipoAlojamiento = scanner.nextLine();

                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese el RUT del cliente: ");
                    String rut = scanner.nextLine();

                    DatosClientes datosCliente = new DatosClientes(nombre, Integer.parseInt(rut));

                    if (tipoAlojamiento.equalsIgnoreCase("Hotel")) {
                        System.out.print("¿Incluye desayuno? (true/false): ");
                        boolean conDesayuno = scanner.nextBoolean();
                        scanner.nextLine(); // Consumir la nueva línea

                        System.out.print("Ingrese el valor base por noche: ");
                        double valorBaseNoche = scanner.nextDouble();

                        System.out.print("Ingrese la capacidad de la habitación: ");
                        int capacidad = scanner.nextInt();

                        System.out.print("Ingrese la cantidad de noches: ");
                        int cantNoches = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Ingrese el tipo de temporada (alta, media, baja): ");
                        String tipoTemporada = scanner.nextLine();

                        System.out.print("¿Es fumador? (true/false): ");
                        boolean esFumador = scanner.nextBoolean();
                        scanner.nextLine();

                        // Crear el objeto `Hotel` con los 7 parámetros requeridos
                        Hotel hotel = new Hotel(datosCliente, valorBaseNoche, cantNoches, tipoTemporada,
                                capacidad, esFumador, conDesayuno);
                        controlador.agregarAlojamiento(hotel);

                    } else if (tipoAlojamiento.equalsIgnoreCase("Cabaña")) {
                        System.out.print("¿Tiene chimenea? (true/false): ");
                        boolean chimenea = scanner.nextBoolean();
                        scanner.nextLine(); // Consumir la nueva línea

                        System.out.print("Ingrese el valor base por noche: ");
                        double valorBaseNoche = scanner.nextDouble();

                        System.out.print("Ingrese la capacidad de la habitación: ");
                        int capacidad = scanner.nextInt();

                        System.out.print("Ingrese la cantidad de noches: ");
                        int cantNoches = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Ingrese el tipo de temporada (alta, media, baja): ");
                        String tipoTemporada = scanner.nextLine();

                        System.out.print("¿Es fumador? (true/false): ");
                        boolean esFumador = scanner.nextBoolean();
                        scanner.nextLine();

                        // Crear el objeto `Hotel` con los 7 parámetros requeridos
                        Cabagna cabagna = new Cabagna(datosCliente, valorBaseNoche, cantNoches, tipoTemporada,
                                capacidad, esFumador, chimenea);
                        controlador.agregarAlojamiento(cabagna);

                    } else if (tipoAlojamiento.equalsIgnoreCase("Carpa")) {
                        System.out.print("Ingrese la capacidad de la carpa: ");
                        int cantidadPersonas = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Ingrese el tipo de temporada (alta, media, baja): ");
                        String tipoTemporada = scanner.nextLine();

                        System.out.print("Ingrese la cantidad de noches: ");
                        int cantNoches = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Ingrese el valor base por noche: ");
                        int valorBaseNoche = scanner.nextInt();

                        Carpa carpa = new Carpa(datosCliente, valorBaseNoche, cantNoches, tipoTemporada, cantidadPersonas);
                        controlador.agregarAlojamiento(carpa);
                    } else {
                        System.out.println("Tipo de alojamiento no válido.");
                    }
                    break;
                case 2: controlador.mostrarAlojamientos(); break;
                case 3: System.out.print("Ingrese el RUT del cliente: ");
                    String rutCliente = scanner.nextLine();
                    controlador.mostrarAlojamientoCliente(rutCliente);
                    break;
                case 4: controlador.calcularTotalAdicional(); break;
                case 5: controlador.calcularTotalBonoDescuento(); break;
                case 6: int cantidad = controlador.CantidadAlojamientos();
                    System.out.println("Cantidad de medios de alojamiento: " + cantidad);; break;
                case 7: System.out.print("Ingrese el RUT del cliente para calculator el valor a cancelar: ");
                    String rutValor = scanner.nextLine();
                    controlador.calcularValorACancelarCliente(rutValor);
                    break;
                case 8: controlador.aplicarIncrementoValorBase(); break;
                case 9: salir = true; System.out.println("Saliendo..."); break;
                default: System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }



}