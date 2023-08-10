import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        List<Integer> valores = new ArrayList<>();

        agregarNumeros(sc, valores);
        calcularLista(valores);

    }

    public static void agregarNumeros(Scanner sc, List<Integer> lista) {

        int num;

        do {

            System.out.println("Ingresa un número");
            num = sc.nextInt();

            if (num != -99){

                lista.add(num);

            }

        } while (num != -99);

    }

    public static void calcularLista(List<Integer> lista) {

        int suma = 0;

        for (int aux : lista) {

            suma += aux;

        }

        double promedio = (double) suma / lista.size();

        System.out.println("Cantidad de números ingresados: " + lista.size());
        System.out.println("Sumatoria de los valores en la lista: " + suma);
        System.out.println("Promedio de los valores en la lista: " + promedio);

    }

}
