package Service;

import Entities.CantanteFamoso;
import Utilities.ComparadorNombreAscendente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CantanteFamosoService {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public void crearCantante(List<CantanteFamoso> lista) {

        System.out.println("Ingresa el nombre del cantante");
        String nombre = sc.next();
        System.out.println("Ingresa el nombre de su disco con mas ventas");
        String discosConMasVentas = sc.next();

        lista.add(new CantanteFamoso(nombre, discosConMasVentas));

        System.out.println("Cantante agregado exitosamente!");

    }

    public void ordenarLista(List<CantanteFamoso> lista) {

        lista.sort(new ComparadorNombreAscendente());

    }

    public void mostrarLista(List<CantanteFamoso> lista) {

        for (CantanteFamoso aux : lista) {

            System.out.println("Nombre: " + aux.getNombre());
            System.out.println("Disco con más ventas: " + aux.getDiscoConMasVentas());

        }

    }

    public void eliminarCantante(List<CantanteFamoso> lista) {

        Iterator<CantanteFamoso> iterator = lista.iterator();
        boolean existeONo = false;

        System.out.println("Ingresa el nombre del cantante que deseas buscar");
        String nombreABuscar = sc.next();

        while (iterator.hasNext()) {

            String nombre = iterator.next().getNombre();

            if (nombre.equalsIgnoreCase(nombreABuscar)) {

                iterator.remove();
                existeONo = true;
                break;

            }

        }

        System.out.println(existeONo ? "El cantante existía y fue eliminado exitosamente."
                : "El cantante no se encontró.");

        ordenarLista(lista);

    }

}
