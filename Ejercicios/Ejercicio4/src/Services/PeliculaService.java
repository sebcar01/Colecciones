package Services;

import Entities.Pelicula;
import Utilities.ComparadorDirector;
import Utilities.ComparadorDuracionAscendente;
import Utilities.ComparadorDuracionDescendente;
import Utilities.ComparadorTitulo;

import java.util.*;

public class PeliculaService {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private List<Pelicula> listadoPeliculas = new ArrayList<>();

    /**
     *
     * Esta funcion se encarga de crear la cantidad de peliculas que el usuario quiera hasta que diga no
     * Las peliculas se guardan en la lista "listadoPeliculas"
     *
     */

    public void crearPelicula() {
        boolean validacionPelicula;
        Pelicula p;

        do {

            System.out.println("Ingresa el nombre de la película");
            String nombre = sc.next();
            System.out.println("Ingresa el nombre del director");
            String director = sc.next();
            System.out.println("Ingresa la duración en horas");
            double duracion = sc.nextDouble();

            p = new Pelicula(nombre, director, duracion);
            listadoPeliculas.add(p);

            System.out.println("Deseas ingresar otra película?");
            String respuestaPelicula = sc.next();
            validacionPelicula = respuestaPelicula.equalsIgnoreCase("si");

        } while (validacionPelicula);

    }

    // Se instancia el iterador para "listadoPeliculas" una vez se crean las peliculas
    private Iterator<Pelicula> iterator = listadoPeliculas.iterator();

    /**
     *
     * Esta funcion recorre cada pelicula y muestra su informacion
     *
     */

    public void mostrarPeliculas() {

        System.out.println("El listado de peliculas a continuación");

        for (Pelicula aux : listadoPeliculas) {

            System.out.println("Nombre: " + aux.getTitulo());
            System.out.println("Director: " + aux.getDirector());
            System.out.println("Duracion: " + aux.getDuracion() + " horas");

        }

        System.out.println("-------------------------------");

    }

    /**
     *
     * Esta funcion hace lo mismo que la funcion 'mostrarPelicula', sin embargo, solo muestra peliculas con una
     * duracion mayor a 1 hora
     *
     */

    public void peliculasConDuracionMayorA1Hora() {

        System.out.println("Películas con una duración mayor a 1 hora");

        for (Pelicula aux : listadoPeliculas) {

            if (aux.getDuracion() > 1) {

                System.out.println("Nombre: " + aux.getTitulo());
                System.out.println("Director: " + aux.getDirector());
                System.out.println("Duracion: " + aux.getDuracion() + " horas");

            }

        }

        System.out.println("-------------------------------");

    }

    /**
     *
     * Esta funcion ordena las peliculas en orden ascendente y luego las muestra
     *
     */



    public void ordenarPeliculasDuracion() {

        boolean validacionRespuesta = true;

        System.out.println("Deseas ordenar las películas por su duración de forma ascendente o descendente? " +
                "Responde ascendente o descendente.");
        String respuesta = sc.next();

        do {

            switch (respuesta) {

                case "ascendente" -> listadoPeliculas.sort(new ComparadorDuracionDescendente());
                case "descendente" -> listadoPeliculas.sort(new ComparadorDuracionAscendente());
                default -> {

                    System.out.println("Respuesta inválida. Intenta de nuevo.");
                    validacionRespuesta = false;
                }

            }

        } while (!validacionRespuesta);

        mostrarPeliculas();

        System.out.println("-------------------------------");

    }

    public void ordenarAlfabeticamente() {

        boolean validacionAtributo = true;

        System.out.println("Deseas ordenar las películas por el título o director? " +
                "Responde titulo o director.");
        String respuesta = sc.next();

        do {

            switch (respuesta) {

                case "titulo" -> listadoPeliculas.sort(new ComparadorTitulo());
                case "director" -> listadoPeliculas.sort(new ComparadorDirector());
                default -> {

                    System.out.println("Respuesta inválida. Intenta de nuevo.");
                    validacionAtributo = false;
                }

            }

        } while (!validacionAtributo);

        mostrarPeliculas();

    }

}
