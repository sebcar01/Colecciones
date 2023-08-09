package Utilities;

import Entities.Pelicula;

import java.util.Comparator;

/**
 *
 * Ordena los números de forma ascendente (mayor a menor)
 *
 */

public class ComparadorDuracionDescendente implements Comparator<Pelicula> {
    @Override
    public int compare(Pelicula p1, Pelicula p2) {

        return Double.compare(p1.getDuracion(), p2.getDuracion());

    }

}
