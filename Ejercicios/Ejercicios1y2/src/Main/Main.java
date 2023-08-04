package Main;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> razas = new ArrayList<>();
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        boolean validacion = true;

        ingresarRazas(razas, sc, validacion);

        Iterator<String> iterator = razas.iterator();

        mostrarRazas(razas);
        busquedaYOrdenamientoRazas(razas, iterator, sc, validacion);
        mostrarRazas(razas);

    }

    public static void ingresarRazas(List<String> al, Scanner sc, boolean validacion) {
        String respuesta;

        do {

            System.out.println("Ingresa una raza de perro");
            al.add(sc.next());

            System.out.println("Deseas ingresar una nueva raza? Responde Sí o No.");
            respuesta = sc.next().toLowerCase();

            validacion = respuesta.equals("si");

        } while (validacion);

    }

    public static void mostrarRazas(List<String> al) {

        System.out.println("Las razas ingresadas se muestran a continuación");

        for (String aux : al) {

            System.out.println(aux);

        }

    }

    public static void busquedaYOrdenamientoRazas(List<String> al, Iterator<String> iterator, Scanner sc, boolean validacion) {
        validacion = false;
        String razaABuscar;

        System.out.println("Ingresa la raza que quieras buscar");
        razaABuscar = sc.next();

        while (iterator.hasNext()) {

           if (iterator.next().equalsIgnoreCase(razaABuscar)) {

               iterator.remove();
               validacion = true;

           }

        }

        System.out.println(validacion ? "Raza encontrada y eliminada" : "La raza no se encontró" );

        Collections.sort(al);

    }

}
