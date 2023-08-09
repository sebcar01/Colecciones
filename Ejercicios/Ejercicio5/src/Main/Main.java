package Main;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        Set<String> paises = new TreeSet<>();

        ingresarPaises(sc, paises);
        mostrarPaises(paises);
        buscarYEliminar(sc, paises);

    }

    public static void ingresarPaises(Scanner sc, Set<String> paises) {

        boolean validarNuevoPais;

        do {

            System.out.println("Ingresa el país");
            String pais = sc.next();

            paises.add(pais);

            System.out.println("Deseas ingresar un nuevo país? Ingresa si o no.");
            String respuesta = sc.next();

            validarNuevoPais = !Objects.equals(respuesta, "no");

        } while (validarNuevoPais);

    }

    public static void mostrarPaises(Set<String> paises) {

        System.out.println("El listado de paises ordenados a continuación");

        for (String aux : paises) {

            System.out.println(aux);

        }

    }

    public static void buscarYEliminar(Scanner sc, Set<String> paises) {

        boolean verificarPais = true;

        Iterator<String> iterator = paises.iterator();

        System.out.println("Ingresa el país que deseas buscar y eliminar");
        String pais = sc.next();

        while (iterator.hasNext()) {

            String elementoActual = iterator.next();

            if (elementoActual.equalsIgnoreCase(pais)) {

                iterator.remove();
                verificarPais = false;

            }

        }

        System.out.println(!verificarPais ? "Pais eliminado exitosamente." : "El pais ingresado no se encuentra en la lista.");

        mostrarPaises(paises);

    }

}
