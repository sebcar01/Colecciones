package Services;

import Entities.Alumno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AlumnoService {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private List<Alumno> alumnos = new ArrayList<Alumno>();
    private boolean validacion = true;

    /**
     * Esta función crea alumnos pidiendole su nombre y tres notas. Estos datos los alberga en dos variables
     * Una variable String con el nombre y una lista con nombre notas, una vez recolectados se instancia el objeto
     * Alumno y se lo pasamos a la lista de alumnos.
     *
     * Se le pregunta al usuario si desea ingresa otro alumno o no, de acuerdo a esto se repetirán o no los mismos
     * pasos
     *
     */

    public void crearAlumno() {

        String nombre;
        String respuesta;
        int nota;

       do {

           System.out.println("Ingresa los datos del alumno");
           System.out.println("Ingresa el nombre");
           nombre = sc.next();

           List<Integer> notas = new ArrayList<Integer>();

           System.out.println("Ingresa las 3 notas");

           for (int i = 1; i <= 3; i++) {

               System.out.println("Nota " + i);
               nota = sc.nextInt();
               notas.add(nota);

           }

           alumnos.add(new Alumno(nombre, notas));

           System.out.println("Deseas ingresar otro alumno? Responde si o no.");
           respuesta = sc.next();

           if (respuesta.equalsIgnoreCase("no")) validacion = false;

       } while (validacion);

    }

    /**
     * Esta función le pide al usuario un nombre, con este nombre se busca dentro del arreglo alumnos si el alumno
     * existe, si el alumno existe, se calcula su promedio y es lo que se imprime.
     *
     * Si el alumno no existe, no se calcula nada y se imprime que el usuario no existe.
     */

    public void notaFinal() {
        int suma = 0;
        String nombre;
        double promedio;

        System.out.println("Ingresa el nombre del alumno para calcular la nota final");
        nombre = sc.next();

        for (Alumno aux : alumnos) {

            if (aux.getNombre().equalsIgnoreCase(nombre)) {

                validacion = true; // El alumno se encontró

                for (int aux1 : aux.getNotas()) {

                    suma += aux1;

                }
                break; // Se coloca para que no se hagan iteraciones innecesarias una vez se encuentre al alumno.
            }

        }

        if (validacion) {

            promedio = ((double) suma / 3);
            System.out.println("El alumno existe, su nota final es: " + promedio);

        } else {

            System.out.println("El alumno no existe.");

        }

    }

}
