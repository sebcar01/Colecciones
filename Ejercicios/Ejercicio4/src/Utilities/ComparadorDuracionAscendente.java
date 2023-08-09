package Utilities;

import Entities.Pelicula;

import java.util.Comparator;

/**
 *
 * Ordena los números de forma ascendente (menor a mayor)
 *
 */
public class ComparadorDuracionAscendente implements Comparator<Pelicula> {
    @Override
    public int compare(Pelicula p1, Pelicula p2) {

        return Double.compare(p2.getDuracion(), p1.getDuracion());

    }

}
