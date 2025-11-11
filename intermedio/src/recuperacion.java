import java.util.Scanner;
public class recuperacion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int velocidadinicial;
        int velocidadfinal;
        int tiempo;
        int distancia;
        System.out.println("Ingrese el valor de velocidad inicial: ");
        velocidadinicial = sc.nextInt();
        System.out.println("Ingrese el valor de velocidad final: ");
        velocidadfinal = sc.nextInt();
        System.out.println("Ingrese el valor de tiempo: ");
        tiempo = sc.nextInt();
        System.out.println("Ingrese el valor de distancia: ");
        distancia = sc.nextInt();
        int velocidadPromedio = velocidadinicial+velocidadfinal*tiempo;
        System.out.println("velocidad promedio es" + velocidadPromedio);
        int distanciaFinal = distancia+velocidadPromedio;
        System.out.println("velocidad final es" + distanciaFinal);
        velocidadPromedio = distancia/tiempo;
        System.out.println("Velocidad promedio es" + velocidadPromedio);
    }
}
