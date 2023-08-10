package Main;

import Entities.CantanteFamoso;
import Service.CantanteFamosoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CantanteFamosoService cfs = new CantanteFamosoService();
        List<CantanteFamoso> cantantes = new ArrayList<>();

        cfs.crearCantante(cantantes);
        cfs.crearCantante(cantantes);
        cfs.crearCantante(cantantes);
        cfs.crearCantante(cantantes);
        cfs.crearCantante(cantantes);
        cfs.ordenarLista(cantantes);
        cfs.mostrarLista(cantantes);
        menuCantantes(cfs, cantantes);
        cfs.mostrarLista(cantantes);

    }

    public static void menuCantantes(CantanteFamosoService cfs, List<CantanteFamoso> cantantes) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        boolean salirONo = false;
        int opcion;

        do {

            System.out.println("Elige alguna de las siguientes opciones");
            System.out.println("1 - Ingresar cantante");
            System.out.println("2 - Mostrar todos los cantantes");
            System.out.println("3 - Eliminar un cantante");
            System.out.println("4 - Salir");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1 -> cfs.crearCantante(cantantes);
                case 2 -> {

                    cfs.ordenarLista(cantantes);
                    cfs.mostrarLista(cantantes);

                }

                case 3 -> cfs.eliminarCantante(cantantes);
                case 4 -> {

                    System.out.println("Gracias por visitar el programa. Adiós!");
                    salirONo = true;

                }
                default -> System.out.println("Opción inválida!");

            }

        } while (!salirONo);

    }

}
