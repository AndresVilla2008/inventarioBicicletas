//import java.util.List;
import java.util.Scanner;
import model.Bicicleta;
import repository.BicicletaRepository;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BicicletaRepository bicicletaRepo = new BicicletaRepository();

        int opcion = 0;
        do {
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Insertar bicicleta nueva");
            System.out.println("2. Consultar lista de bicicletas");
            System.out.println("3. Consultar bicicleta");
            System.out.println("4. Eliminar bicicleta");
            System.out.println("5. Actualizar bicicleta");
            System.out.println("6. Salir del sistema");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese código: ");
                    String codigo = scanner.nextLine();

                    System.out.print("Ingrese marca: ");
                    String marca = scanner.nextLine();

                    System.out.print("Ingrese color: ");
                    String color = scanner.nextLine();

                    System.out.print("Ingrese tamaño: ");
                    String tamaño = scanner.nextLine();

                    System.out.print("Ingrese precio: ");
                    Double precio = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Ingrese estado (1: Disponible, 2: No Disponible): ");
                    Integer estado = scanner.nextInt();
                    scanner.nextLine();

                    Bicicleta bici = new Bicicleta(codigo, marca, color, tamaño, precio, estado);
                    bicicletaRepo.insertarBicicleta(bici);
                    break;

                case 2:
                    System.out.println("Lista de bicicletas:");
                    for (Bicicleta b : bicicletaRepo.listarBicicletas()) {
                        System.out.println("Id: " + b.getId_bicicleta() +
                                ", Código: " + b.getCodigo() +
                                ", Marca: " + b.getMarca() +
                                ", Color: " + b.getColor() +
                                ", Tamaño: " + b.getTamaño() +
                                ", Precio: $" + b.getPrecio() +
                                ", Estado: " + b.getEstadoTexto());
                    }
                    break;

                case 3:
                    System.out.println("Ingrese el código de la bicicleta que desea consultar:");
                    String codigoBuscar = scanner.nextLine();
                    Bicicleta bicicletaEncontrada = bicicletaRepo.mostrarBicicleta(codigoBuscar);

                    if(bicicletaEncontrada != null) {
                        System.out.println("Bicicleta encontrada: ");
                        System.out.println("Id: " + bicicletaEncontrada.getId_bicicleta() +
                                ", Código: " + bicicletaEncontrada.getCodigo() +
                                ", Marca: " + bicicletaEncontrada.getMarca() +
                                ", Color: " + bicicletaEncontrada.getColor() +
                                ", Tamaño: " + bicicletaEncontrada.getTamaño() +
                                ", Precio: $" + bicicletaEncontrada.getPrecio() +
                                ", Estado: " + bicicletaEncontrada.getEstadoTexto());
                    } else {
                        System.out.println("Bicicleta no encontrada.");
                    }
                    break;

                case 4:
                    System.out.println("Ingrese el ID de la bicicleta que desea eliminar:");
                    int eliminarId = scanner.nextInt();
                    BicicletaRepository.eliminarBicicleta(eliminarId);
                    break;

                case 5:
                    System.out.println("Ingrese el ID de la bicicleta que desea actualizar:");
                    int actualizarId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese el nuevo código: ");
                    String nuevoCodigo = scanner.nextLine();

                    System.out.print("Ingrese la nueva marca: ");
                    String nuevaMarca = scanner.nextLine();

                    System.out.print("Ingrese el nuevo color: ");
                    String nuevoColor = scanner.nextLine();

                    System.out.print("Ingrese el nuevo tamaño: ");
                    String nuevoTamaño = scanner.nextLine();

                    System.out.print("Ingrese el nuevo precio: ");
                    Double nuevoPrecio = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Ingrese el nuevo estado (1: Disponible, 2: No Disponible): ");
                    Integer nuevoEstado = scanner.nextInt();
                    scanner.nextLine();
                    
                    Bicicleta bicicletaActualizar = new Bicicleta(actualizarId, nuevoCodigo, nuevaMarca, nuevoColor, nuevoTamaño, nuevoPrecio, nuevoEstado);
                    BicicletaRepository.actualizarBicicleta(bicicletaActualizar);
                    break;
                    
                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
            System.out.println("----------------------");
        } while (opcion != 6);
        scanner.close();
    }
}
