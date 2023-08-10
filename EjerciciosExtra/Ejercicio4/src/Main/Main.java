package Main;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        Map<Integer, String> codigosPostales = new TreeMap<>();

        agregarElementos(codigosPostales, sc);
        agregarElementos(codigosPostales, sc);
        agregarElementos(codigosPostales, sc);
        mostrarElementos(codigosPostales);
        buscarElementos(codigosPostales, sc);
        agregarElementos(codigosPostales, sc);
        eliminarElemento(codigosPostales, sc);
        mostrarElementos(codigosPostales);

    }

    public static void agregarElementos(Map<Integer, String> cp, Scanner sc) {

        System.out.println("Ingresa el código postal");
        int codigo = sc.nextInt();
        System.out.println("Ingresa la ciudad asociada a ese código postal");
        String ciudad = sc.next();

        cp.put(codigo, ciudad);

    }

    public static void mostrarElementos(Map<Integer, String> cp) {

        for (Map.Entry<Integer, String> entry : cp.entrySet()) {

            System.out.println("Código postal: " + entry.getKey() + ", Ciudad: " + entry.getValue());

        }

    }

    public static void buscarElementos(Map<Integer, String> cp, Scanner sc) {

        boolean existeONo = false;

        System.out.println("Ingresa el código postal que deseas buscar");
        int codigo = sc.nextInt();

        for (Map.Entry<Integer, String> entry : cp.entrySet()) {

            if (codigo == entry.getKey()) {

                System.out.println("El código existe, la ciudad es: " + entry.getValue());
                existeONo = true;
                break;
            }

        }

        if (!existeONo) System.out.println("El código postal ingresado no existe.");

    }

    public static void eliminarElemento(Map<Integer, String> cp, Scanner sc) {

        boolean existeONo = false;
        Iterator<Map.Entry<Integer, String>> iterator = cp.entrySet().iterator();

        System.out.println("Ingresa la ciudad que deseas eliminar");
        String nombre = sc.next();

        while (iterator.hasNext()) {

            Map.Entry<Integer, String> entry = iterator.next();

            if (nombre.equalsIgnoreCase(entry.getValue())) {

                iterator.remove();
                existeONo = true;
                System.out.println("Ciudad eliminada exitosamente!");

            }

        }

        if (!existeONo) System.out.println("La ciudad ingresada no existe.");

    }

}
