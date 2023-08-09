package Main;

import Services.PeliculaService;

public class Main {

    public static void main(String[] args) {

        PeliculaService ps = new PeliculaService();

        ps.crearPelicula();
        ps.mostrarPeliculas();
        ps.peliculasConDuracionMayorA1Hora();
        ps.ordenarPeliculasDuracion();
        ps.ordenarAlfabeticamente();

    }

}
