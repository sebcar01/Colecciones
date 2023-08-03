package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<String> razas = new ArrayList<>();
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        boolean validacion;
        String respuesta = "";

        do {

            System.out.println("Ingresa una raza de perro");
            razas.add(sc.next());

            System.out.println("Deseas ingresar una nueva raza? Responde Sí o No.");
            respuesta = sc.next().toLowerCase();

            validacion = respuesta.equals("si");

        } while (validacion);

        System.out.println("Las razas ingresadas se muestran a continuación");

        for (String aux : razas) {

            System.out.println(aux);

        }

    }

}
