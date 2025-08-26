package pe.edu.upeu;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class OPERACIONES {
    public static void main(String[] args) {

        Scanner nelida = new Scanner(System.in);

        //ENTRADA
        System.out.println("INGRESA EL PRIMER NUMERO");
        int N1 = nelida.nextInt();
        System.out.println("INGRESA EL SEGUNDO NUMERO");
        int N2 = nelida.nextInt();

        //PROCESO
        int suma = N1 + N2;
        int resta = N1 - N2;
        int multiplicacion = N1 * N2;
        int division = N1 / N2;
        int modulo = N1 % N2;

        //SALIDA
        System.out.println("SUMA:"+suma);
        System.out.println("RESTA:"+resta);
        System.out.println("MULTIPLICACION:"+multiplicacion);
        System.out.println("DIVISION:"+division);
        System.out.println("MODULO:"+modulo);
    }
}