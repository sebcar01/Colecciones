package Services;

import Entities.Alumno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AlumnoService {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    List<Alumno> alumnos = new ArrayList<Alumno>();
    boolean validacion = true;

    public void crearAlumno() {

        String nombre;
        String respuesta;
        int nota;

       do {

           System.out.println("Ingresa los datos del alumno");
           System.out.println("Ingresa el nombre");
           nombre = sc.next();

           List<Integer> notasI = new ArrayList<Integer>();

           System.out.println("Ingresa las 3 notas");

           for (int i = 1; i <= 3; i++) {

               System.out.println("Nota " + i);
               nota = sc.nextInt();
               notasI.add(nota);

           }

           alumnos.add(new Alumno(nombre, notasI));

           System.out.println("Deseas ingresar otro alumno? Responde si o no.");
           respuesta = sc.next();

           if (respuesta.equalsIgnoreCase("no")) validacion = false;

       } while (validacion);

    }

    public void notaFinal() {
        int suma = 0;
        String nombre;
        double promedio;

        System.out.println("Ingresa el nombre del alumno para calcular la nota final");
        nombre = sc.next();

        for (Alumno aux : alumnos) {

            if (aux.getNombre().equalsIgnoreCase(nombre)) {

                for (int aux1 : aux.getNotas()) {

                    suma += aux1;
                    validacion = true;

                }

            }

        }

        promedio = ((double) suma / 3);

        System.out.print(validacion ? "El alumno existe, su nota final es: " + promedio : "El alumno no existe.");

    }

}
