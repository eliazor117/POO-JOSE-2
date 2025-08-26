package pe.edu.upeu;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Areatriangulo {

    public static void main(String[] args) {

        Scanner nelida=new Scanner(System.in);
        //ENTRADA
        System.out.println("INGRESA LA BASE");
        double base=nelida.nextDouble();
        System.out.println("INGRESA ALTURA");
        double altura=nelida.nextDouble();

        //PROCESO
        double areadetriangulo=(base*altura)/2;

        //SALIDA
        System.out.println("EL AREA DEL TRIANGULO ES:"+areadetriangulo);

    }
}