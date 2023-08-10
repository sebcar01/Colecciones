package Service;

import java.util.*;

public class TiendaService {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private Map<String, Double> productosTienda = new TreeMap<>();

    public void menuTienda() {

        boolean salirONo = true;

        do {

            System.out.println("Elige una de las siguientes opciones");
            System.out.println("1 - Introducir un elemento");
            System.out.println("2 - Buscar producto. Podrás modificar su precio o eliminarlo.");
            System.out.println("3 - Mostrar todos los productos.");
            System.out.println("4 - Salir");
            int opcion = sc.nextInt();

            switch (opcion) {

                case 1 -> introducirElemento();
                case 2 -> manipularProducto();
                case 3 -> mostrarProductos();
                case 4 -> {

                    System.out.println("Gracias por visitar el programa. Adios!");
                    salirONo = false;

                }

                default -> System.out.println("La opción seleccionada no es válida.");

            }

        } while (salirONo);

    }

    public void introducirElemento() {

        System.out.println("Ingresa el nuevo producto");
        System.out.println("Nombre del producto");
        String nombre = sc.next();
        System.out.println("Precio del producto");
        double precio = sc.nextDouble();

        productosTienda.put(nombre, precio);

    }

    public void manipularProducto() {

        boolean existeONo = false;
        boolean validacionMenu;

        System.out.println("Ingresa el nombre del producto que deseas buscar");
        String nombre = sc.next();

        for (Map.Entry<String, Double> entry : productosTienda.entrySet()) {

            if (entry.getKey().equalsIgnoreCase(nombre)) {

                do {

                    System.out.println("El producto existe! Elige que deseas hacer con el producto");
                    System.out.println("1 - Modificar precio");
                    System.out.println("2 - Eliminar el producto");
                    int opcion = sc.nextInt();

                    switch (opcion) {

                        case 1 -> {

                            System.out.println("Ingresa el nuevo precio");
                            double precio = sc.nextDouble();
                            entry.setValue(precio);
                            System.out.println("Precio modificado exitosamente!");
                            validacionMenu = true;

                        }
                        case 2 -> {

                            productosTienda.remove(entry.getKey());
                            System.out.println("Producto eliminado exitosamente!");
                            validacionMenu = true;

                        }

                        default -> {

                            System.out.println("Opción inválida!");
                            validacionMenu = false;

                        }

                    }

                } while (!validacionMenu);

                existeONo = true;
                break;

            }

        }

        if (!existeONo) System.out.println("El producto no existe.");

    }

    public void mostrarProductos() {

        System.out.println("Listado de productos a continuación");
        for (Map.Entry<String, Double> entry : productosTienda.entrySet()) {

            System.out.println("Producto: " + entry.getKey());
            System.out.println("Precio: $" + entry.getValue());

        }

    }

}
