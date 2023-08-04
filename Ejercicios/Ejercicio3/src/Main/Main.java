package Main;

import Services.AlumnoService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        AlumnoService as = new AlumnoService();

        as.crearAlumno();
        as.notaFinal();

    }

}
