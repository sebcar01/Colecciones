package Services;

import Entities.Libro;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LibroService {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public void crearLibro(Set<Libro> libros) {

        System.out.println("Ingresa el título");
        String titulo = sc.next();
        System.out.println("Ingresa el autor");
        String autor = sc.next();
        System.out.println("Ingresa el número de ejemplares");
        int ejemplares = sc.nextInt();

        libros.add(new Libro(titulo, autor, ejemplares, 0));

    }

    public boolean buscarLibro(Set<Libro> libros, String titulo) {

        for (Libro aux : libros) {

            return aux.getTitulo().equalsIgnoreCase(titulo);

        }

        return false;

    }

    public void prestamo(Set<Libro> libros) {

        System.out.println("Ingresa el título del libro que deseas tomar en préstamo");
        String titulo = sc.next();

        boolean existeONo = buscarLibro(libros, titulo);

        if (existeONo) {

            System.out.println("El libro existe");

        } else {

            System.out.println("El libro no existe. Intenta de nuevo.");
            prestamo(libros);

        }

        for (Libro aux : libros) {

            if (aux.getTitulo().equalsIgnoreCase(titulo)) {

                if (aux.getNumeroDeEjemplares() <= aux.getEjemplaresPrestados()) {

                    System.out.println("No quedan ejemplares disponibles para préstamo :(");
                    break;

                } else {

                    aux.setEjemplaresPrestados(aux.getEjemplaresPrestados() + 1);
                    System.out.println("Libro prestado exitosamente!");

                }

            }

        }

    }

    public void devolucion(Set<Libro> libros) {

        System.out.println("Ingresa el título del libro que deseas devolver");
        String titulo = sc.next();

        boolean existeONo = buscarLibro(libros, titulo);

        if (existeONo) {

            System.out.println("El libro existe");

        } else {

            System.out.println("El libro no existe. Intenta de nuevo.");
            devolucion(libros);

        }

        for (Libro aux : libros) {

            if (aux.getTitulo().equalsIgnoreCase(titulo)) {

                if (aux.getEjemplaresPrestados() == 0) {

                    System.out.println("No existen ejemplares en préstamo, por lo tanto es inválida esta devolución.");
                    break;

                } else {

                    aux.setEjemplaresPrestados(aux.getEjemplaresPrestados() - 1);
                    System.out.println("Libro devuelto exitosamente!");

                }

            }

        }

    }

    public void mostrarLibros(Set<Libro> libros) {

        for (Libro aux : libros) {

            System.out.println(aux);

        }

    }

}
