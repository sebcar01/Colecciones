package Utilities;

import Entities.CantanteFamoso;

import java.util.Comparator;

public class ComparadorNombreAscendente implements Comparator<CantanteFamoso> {

    @Override
    public int compare(CantanteFamoso cf1, CantanteFamoso cf2) {

        return cf1.getNombre().compareTo(cf2.getNombre());

    }

}
