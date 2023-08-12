package Main;

import Entities.Libro;
import Services.LibroService;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        LibroService ls = new LibroService();
        Set<Libro> libros = new HashSet<>();

        creadorDeLibros(ls, sc, libros);
        ls.prestamo(libros);
        ls.mostrarLibros(libros);
        ls.devolucion(libros);
        ls.mostrarLibros(libros);
        ls.devolucion(libros);
        ls.mostrarLibros(libros);

    }

    public static void creadorDeLibros(LibroService ls, Scanner sc, Set<Libro> libros) {

        boolean ingresarOtroLibroONo = false;

        do {

            ls.crearLibro(libros);

            System.out.println("Deseas ingresar otro libro?. Responde si o no.");
            String respuesta = sc.next().toLowerCase();

            switch (respuesta) {

                case "si" -> ingresarOtroLibroONo = true;
                case "no" -> {

                    System.out.println("Gracias por visitar el programa. Adiós!");
                    ingresarOtroLibroONo = false;

                }
                default -> {

                    System.out.println("La opción ingresada es inválida. Intenta de nuevo");
                    ingresarOtroLibroONo = true;

                }

            }

        } while (ingresarOtroLibroONo);

    }

}
