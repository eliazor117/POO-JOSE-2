¡Por supuesto! Aquí tienes la traducción de las soluciones del balotario al lenguaje Java, con un enfoque en la simplicidad para alguien que está aprendiendo a programar.
Nivel Fácil
FizzBuzz
        java
public class FizzBuzz {
    public static void main(String[] args) {
        for (int numero = 1; numero <= 100; numero++) {
            if (numero % 3 == 0 && numero % 5 == 0) {
                System.out.println("fizzbuzz");
            } else if (numero % 3 == 0) {
                System.out.println("fizz");
            } else if (numero % 5 == 0) {
                System.out.println("buzz");
            } else {
                System.out.println(numero);
            }
        }
    }
}
Explicación: Similar a la versión en Python, este código recorre los números del 1 al 100 y usa el operador % (módulo) para verificar si un número es divisible por 3 o 5.
Área de un Polígono
java
public class AreaPoligono {
    public static double calcularArea(String poligono, double base, double altura) {
        if (poligono.equals("triangulo")) {
            return (base * altura) / 2;
        } else if (poligono.equals("rectangulo")) {
            return base * altura;
        } else {
            System.out.println("Polígono no soportado");
            return 0; // O algún valor de error
        }
    }

    public static void main(String[] args) {
        double areaTriangulo = calcularArea("triangulo", 5, 8);
        double areaRectangulo = calcularArea("rectangulo", 4, 6);

        System.out.println("Área del triángulo: " + areaTriangulo);
        System.out.println("Área del rectángulo: " + areaRectangulo);
    }
}
Explicación: Define una función que toma el tipo de polígono y sus dimensiones. Utiliza equals() para comparar cadenas en Java.
Invertir Cadena
java
public class InvertirCadena {
    public static String invertirCadena(String cadena) {
        String cadenaInvertida = "";
        for (int i = cadena.length() - 1; i >= 0; i--) {
            cadenaInvertida += cadena.charAt(i);
        }
        return cadenaInvertida;
    }

    public static void main(String[] args) {
        String texto = "Hola mundo";
        String textoInvertido = invertirCadena(texto);
        System.out.println(textoInvertido); // Salida: odnum aloH
    }
}
Explicación: Recorre la cadena desde el último carácter hasta el primero, construyendo una nueva cadena invertida. Utiliza charAt(i) para obtener el carácter en la posición i.
Decimal a Binario
        java
public class DecimalABinario {
    public static String decimalABinario(int decimal) {
        String binario = "";
        while (decimal > 0) {
            int residuo = decimal % 2;
            binario = residuo + binario; // Añade el residuo al inicio
            decimal = decimal / 2; // División entera
        }
        return binario.isEmpty() ? "0" : binario; // Si el número es 0, retorna "0"
    }

    public static void main(String[] args) {
        int numeroDecimal = 10;
        String numeroBinario = decimalABinario(numeroDecimal);
        System.out.println(numeroBinario); // Salida: 1010
    }
}
Explicación: Divide el número decimal por 2 en cada iteración. El residuo (0 o 1) se añade al inicio de la cadena binaria.
Caracteres No Comunes
        java
public class CaracteresNoComunes {
    public static void caracteresNoComunes(String str1, String str2) {
        String out1 = "";
        String out2 = "";

        for (int i = 0; i < str1.length(); i++) {
            char char1 = str1.charAt(i);
            if (str2.indexOf(char1) == -1) {
                out1 += char1;
            }
        }

        for (int i = 0; i < str2.length(); i++) {
            char char2 = str2.charAt(i);
            if (str1.indexOf(char2) == -1) {
                out2 += char2;
            }
        }

        System.out.println("out1: " + out1);
        System.out.println("out2: " + out2);
    }

    public static void main(String[] args) {
        caracteresNoComunes("casa", "calle");
    }
}
Explicación: Recorre cada cadena y añade los caracteres que no están en la otra a las cadenas de salida.
Factorial Recursivo
java
public class Factorial {
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        int numero = 5;
        int resultado = factorial(numero);
        System.out.println("El factorial de " + numero + " es " + resultado);
    }
}
Explicación: Si n es 0, retorna 1. Sino, retorna n multiplicado por el factorial de n-1.
Número de Armstrong
        java
public class NumeroArmstrong {
    public static boolean esArmstrong(int numero) {
        String numStr = String.valueOf(numero);
        int n = numStr.length();
        int suma = 0;
        for (int i = 0; i < n; i++) {
            int digito = Character.getNumericValue(numStr.charAt(i));
            suma += Math.pow(digito, n);
        }
        return suma == numero;
    }

    public static void main(String[] args) {
        int numero = 153;
        if (esArmstrong(numero)) {
            System.out.println(numero + " es un número de Armstrong");
        } else {
            System.out.println(numero + " no es un número de Armstrong");
        }
    }
}
Explicación: Calcula la suma de cada dígito elevado a la potencia del número de dígitos. Si la suma es igual al número original, es un número de Armstrong.
Primera Letra en Mayúscula
java
public class PrimeraLetraMayuscula {
    public static String primeraLetraMayuscula(String texto) {
        String[] palabras = texto.split(" ");
        StringBuilder resultado = new StringBuilder();
        for (String palabra : palabras) {
            if (!palabra.isEmpty()) { // Evitar errores con palabras vacías
                resultado.append(Character.toUpperCase(palabra.charAt(0)))
                        .append(palabra.substring(1))
                        .append(" ");
            }
        }
        return resultado.toString().trim(); // Elimina el espacio final
    }

    public static void main(String[] args) {
        String texto = "hola mundo cruel";
        String textoModificado = primeraLetraMayuscula(texto);
        System.out.println(textoModificado); // Salida: Hola Mundo Cruel
    }
}
Explicación: Divide el texto en palabras, pone en mayúscula la primera letra de cada palabra y las vuelve a unir. Utiliza StringBuilder para construir la nueva cadena de manera eficiente.
Tiempo a Milisegundos
        java
public class TiempoAMilisegundos {
    public static long tiempoAMilisegundos(int dias, int horas, int minutos, int segundos) {
        long milisegundos = (long) (dias * 24 * 60 * 60 + horas * 60 * 60 + minutos * 60 + segundos) * 1000;
        return milisegundos;
    }

    public static void main(String[] args) {
        int dias = 1;
        int horas = 2;
        int minutos = 30;
        int segundos = 15;
        long totalMilisegundos = tiempoAMilisegundos(dias, horas, minutos, segundos);
        System.out.println("Total milisegundos: " + totalMilisegundos);
    }
}
Explicación: Convierte cada unidad de tiempo a milisegundos y las suma. Es importante usar long para evitar desbordamientos.
Elementos Comunes/No Comunes en Arrays
java
import java.util.ArrayList;
import java.util.List;

public class ElementosComunesNoComunes {
    public static List<Integer> elementosComunesNoComunes(int[] array1, int[] array2, boolean buscarComunes) {
        List<Integer> resultado = new ArrayList<>();
        for (int elemento : array1) {
            boolean enArray2 = false;
            for (int valor : array2) {
                if (elemento == valor) {
                    enArray2 = true;
                    break;
                }
            }
            if ((enArray2 == buscarComunes) && !resultado.contains(elemento)) {
                resultado.add(elemento);
            }
        }
        for (int elemento : array2) {
            boolean enArray1 = false;
            for (int valor : array1) {
                if (elemento == valor) {
                    enArray1 = true;
                    break;
                }
            }
            if ((enArray1 == buscarComunes) && !resultado.contains(elemento)) {
                resultado.add(elemento);
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {3, 5, 6, 7};

        List<Integer> comunes = elementosComunesNoComunes(array1, array2, true);
        List<Integer> noComunes = elementosComunesNoComunes(array1, array2, false);

        System.out.println("Comunes: " + comunes);
        System.out.println("No comunes: " + noComunes);
    }
}
Explicación: Recorre los arrays y verifica si los elementos están presentes en ambos (comunes) o solo en uno (no comunes). Utiliza ArrayList para almacenar los resultados.
Contar del 1 al 100 de Diferentes Maneras
        java
public class ContarDel1Al100 {
    public static void main(String[] args) {
        // Manera 1: Bucle for
        System.out.println("Manera 1: Bucle for");
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }

        // Manera 2: Bucle while
        System.out.println("\nManera 2: Bucle while");
        int contador = 1;
        while (contador <= 100) {
            System.out.println(contador);
            contador++;
        }

        // Manera 3: Recursión (¡Ojo! Puede ser menos eficiente)
        System.out.println("\nManera 3: Recursión");
        contar(1);
    }

    public static void contar(int n) {
        if (n <= 100) {
            System.out.println(n);
            contar(n + 1);
        }
    }
}
Explicación: Muestra tres maneras diferentes de lograr el mismo resultado: usando un bucle for, un bucle while y recursión.
Dibujar Cuadrado o Triángulo con Asteriscos
java
public class DibujarFigura {
    public static void dibujarFigura(int lado, String figura) {
        if (figura.equals("cuadrado")) {
            for (int i = 0; i < lado; i++) {
                for (int j = 0; j < lado; j++) {
                    System.out.print("*");
                }
                System.out.println(); // Nueva línea
            }
        } else if (figura.equals("triangulo")) {
            for (int i = 1; i <= lado; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }
                System.out.println(); // Nueva línea
            }
        } else {
            System.out.println("Figura no soportada");
        }
    }

    public static void main(String[] args) {
        dibujarFigura(5, "cuadrado");
        System.out.println();
        dibujarFigura(5, "triangulo");
    }
}
Explicación: Usa bucles anidados for para imprimir asteriscos y formar las figuras.
        Vectores Ortogonales
java
public class VectoresOrtogonales {
    public static boolean sonOrtogonales(int[] vector1, int[] vector2) {
        if (vector1.length != vector2.length) {
            return false; // Deben tener la misma longitud
        }
        int productoPunto = 0;
        for (int i = 0; i < vector1.length; i++) {
            productoPunto += vector1[i] * vector2[i];
        }
        return productoPunto == 0;
    }

    public static void main(String[] args) {
        int[] vector1 = {1, -2};
        int[] vector2 = {2, 1};
        if (sonOrtogonales(vector1, vector2)) {
            System.out.println("Los vectores son ortogonales");
        } else {
            System.out.println("Los vectores no son ortogonales");
        }
    }
}
Explicación: Calcula el producto punto de los vectores. Si el resultado es 0, son ortogonales.
Ordenar Matriz de Números
java
public class OrdenarMatriz {
    public static int[] ordenarMatriz(int[] lista, String orden) {
        int n = lista.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orden.equals("Asc") && lista[j] > lista[j + 1]) {
                    // Intercambio
                    int temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                } else if (orden.equals("Desc") && lista[j] < lista[j + 1]) {
                    // Intercambio
                    int temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                }
            }
        }
        return lista;
    }

    public static void main(String[] args) {
        int[] lista = {2, 4, 6, 8, 9};
        int[] ascendente = ordenarMatriz(lista.clone(), "Asc"); // Clonar para no modificar el original
        int[] descendente = ordenarMatriz(lista.clone(), "Desc");

        System.out.print("Ascendente: ");
        for (int num : ascendente) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Descendente: ");
        for (int num : descendente) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
Explicación: Implementa el algoritmo de "Bubble Sort" para ordenar la lista en orden ascendente o descendente. Usa clone() para evitar modificar el array original.
Próximos Años Bisiestos
        java
public class ProximosBisiestos {
    public static void proximosBisiestos(int añoInicial) {
        int contador = 0;
        int año = añoInicial + 1;
        while (contador < 30) {
            if ((año % 4 == 0 && año % 100 != 0) || (año % 400 == 0)) {
                System.out.println(año);
                contador++;
            }
            año++;
        }
    }

    public static void main(String[] args) {
        proximosBisiestos(2024);
    }
}
Explicación: Itera a través de los años, verificando si son bisiestos y mostrándolos.
Segundo Más Grande
        java
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SegundoMasGrande {
    public static Integer segundoMasGrande(int[] lista) {
        Set<Integer> set = new HashSet<>();
        for (int num : lista) {
            set.add(num);
        }
        if (set.size() < 2) {
            return null; // No hay un segundo más grande
        }
        Integer[] listaOrdenada = set.toArray(new Integer[0]);
        Arrays.sort(listaOrdenada);
        return listaOrdenada[listaOrdenada.length - 2];
    }

    public static void main(String[] args) {
        int[] lista = {1, 2, 3, 4, 5};
        Integer segundo = segundoMasGrande(lista);
        if (segundo != null) {
            System.out.println("Segundo más grande: " + segundo);
        } else {
            System.out.println("No hay un segundo más grande");
        }
    }
}
Explicación: Elimina duplicados, ordena la lista y retorna el segundo elemento desde el final.
Binario a Decimal
        java
public class BinarioADecimal {
    public static int binarioADecimal(String binario) {
        int decimal = 0;
        int potencia = 0;
        for (int i = binario.length() - 1; i >= 0; i--) {
            if (binario.charAt(i) == '1') {
                decimal += Math.pow(2, potencia);
            }
            potencia++;
        }
        return decimal;
    }

    public static void main(String[] args) {
        String binario = "101101";
        int decimal = binarioADecimal(binario);
        System.out.println("Decimal: " + decimal);
    }
}
Explicación: Recorre la cadena binaria desde el final, sumando las potencias de 2 correspondientes a los dígitos '1'.
Número de Bumeranes
        java
import java.util.ArrayList;
import java.util.List;

public class NumeroBumeranes {
    public static int contarBumeranes(int[] lista) {
        int contador = 0;
        List<String> bumeranes = new ArrayList<>();
        for (int i = 0; i < lista.length - 2; i++) {
            if (lista[i] == lista[i + 2] && lista[i] != lista[i + 1]) {
                contador++;
                bumeranes.add("(" + lista[i] + ", " + lista[i + 1] + ", " + lista[i + 2] + ")");
            }
        }
        System.out.println("Bumeranes encontrados: " + bumeranes);
        return contador;
    }

    public static void main(String[] args) {
        int[] lista = {2, 1, 2, 3, 3, 4, 2, 4};
        int cantidad = contarBumeranes(lista);
        System.out.println("Cantidad de bumeranes: " + cantidad);
    }
}
Explicación: Recorre la lista, verificando si tres números consecutivos forman un bumerán.
Vocal Más Repetida
        java
public class VocalMasRepetida {
    public static char vocalMasRepetida(String texto) {
        texto = texto.toLowerCase();
        String vocales = "aeiou";
        int[] contadorVocales = new int[5]; // a, e, i, o, u

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            int index = vocales.indexOf(c);
            if (index != -1) {
                contadorVocales[index]++;
            }
        }

        char vocalMasComun = ' ';
        int maxRepeticiones = 0;

        for (int i = 0; i < contadorVocales.length; i++) {
            if (contadorVocales[i] > maxRepeticiones) {
                maxRepeticiones = contadorVocales[i];
                vocalMasComun = vocales.charAt(i);
            }
        }

        return vocalMasComun;
    }

    public static void main(String[] args) {
        String texto = "murcielago";
        char vocal = vocalMasRepetida(texto);
        System.out.println("Vocal más repetida: " + vocal);
    }
}
Explicación: Cuenta la frecuencia de cada vocal y retorna la más repetida.
Obtener Valores de URL
java
import java.util.ArrayList;
import java.util.List;

public class ObtenerValoresURL {
    public static List<String> obtenerValoresURL(String url) {
        List<String> valores = new ArrayList<>();
        String[] partes = url.split("\\?");
        if (partes.length < 2) {
            return valores; // No hay parámetros
        }
        String[] parametros = partes[1].split("&");
        for (String parametro : parametros) {
            String[] valorPar = parametro.split("=");
            if (valorPar.length > 1) {
                valores.add(valorPar[1]);
            }
        }
        return valores;
    }

    public static void main(String[] args) {
        String url = "https://retosdeprogramacion.com?year=2023&challenge=0";
        List<String> valores = obtenerValoresURL(url);
        System.out.println("Valores: " + valores);
    }
}
Explicación: Divide la URL para extraer los parámetros y sus valores.
Viernes 13
java
import java.time.LocalDate;
import java.time.DayOfWeek;

public class Viernes13 {
    public static boolean esViernes13(int mes, int año) {
        try {
            LocalDate fecha = LocalDate.of(año, mes, 13);
            return fecha.getDayOfWeek() == DayOfWeek.FRIDAY;
        } catch (java.time.DateTimeException e) {
            return false; // Fecha inválida
        }
    }

    public static void main(String[] args) {
        int mes = 10;
        int año = 2025;
        if (esViernes13(mes, año)) {
            System.out.println("Es viernes 13");
        } else {
            System.out.println("No es viernes 13");
        }
    }
}
Explicación: Utiliza la clase LocalDate de la API de Java 8 para verificar si el 13 del mes dado es viernes.
Decimal a Octal y Hexadecimal
        java
public class DecimalAOctalHexadecimal {
    public static String[] decimalAOctalHexadecimal(int decimal) {
        String octal = Integer.toOctalString(decimal);
        String hexadecimal = Integer.toHexString(decimal).toUpperCase();
        return new String[]{octal, hexadecimal};
    }

    public static void main(String[] args) {
        int decimal = 255;
        String[] resultados = decimalAOctalHexadecimal(decimal);
        System.out.println("Octal: " + resultados[0]);
        System.out.println("Hexadecimal: " + resultados[1]);
    }
}
Explicación: En este caso, podemos usar las funciones Integer.toOctalString() y Integer.toHexString() directamente.
Operaciones Básicas con Dos Números
        java
public class OperacionesBasicas {
    public static void operacionesBasicas(double num1, double num2) {
        double suma = num1 + num2;
        double resta = num1 - num2;
        double producto = num1 * num2;
        String division;
        if (num2 != 0) {
            division = String.valueOf(num1 / num2);
        } else {
            division = "No se puede dividir por cero";
        }

        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Producto: " + producto);
        System.out.println("División: " + division);
    }

    public static void main(String[] args) {
        operacionesBasicas(10, 5);
    }
}
Explicación: Realiza las operaciones básicas y muestra los resultados.24. Porcentaje de Niños y Niñas
        java
public class PorcentajeGenero {
    public static void porcentajeGenero(int niños, int niñas) {
        int total = niños + niñas;
        double porcentajeNiños = (double) niños / total * 100;
        double porcentajeNiñas = (double) niñas / total * 100;

        System.out.println("Porcentaje de niños: " + porcentajeNiños + "%");
        System.out.println("Porcentaje de niñas: " + porcentajeNiñas + "%");
    }

    public static void main(String[] args) {
        porcentajeGenero(30, 20);
    }
}
Explicación: Calcula los porcentajes utilizando una regla de tres simple.25. IGV con Descuento
        java
public class IGVConDescuento {
    public static void calcularIGVDescuento(double venta) {
        double totalAPagar;
        if (venta > 150000) {
            double descuento = venta * 0.25;
            double ventaConDescuento = venta - descuento;
            double igv = ventaConDescuento * 0.18;
            totalAPagar = ventaConDescuento + igv;
        } else {
            double igv = venta * 0.18;
            totalAPagar = venta + igv;
        }

        System.out.println("Total a pagar: " + totalAPagar);
    }

    public static void main(String[] args) {
        calcularIGVDescuento(160000);
    }
}
Explicación: Aplica el descuento si la venta es mayor a 150000 y luego calcula el IGV.26. Invertir Número de Dos Cifras
        java
public class InvertirNumero {
    public static String invertirNumero(int numero) {
        if (10 <= numero && numero <= 99) {
            int decenas = numero / 10;
            int unidades = numero % 10;
            int numeroInvertido = (unidades * 10) + decenas;
            return String.valueOf(numeroInvertido);
        } else {
            return "Número no válido";
        }
    }

    public static void main(String[] args) {
        int numero = 23;
        String invertido = invertirNumero(numero);
        System.out.println("Número invertido: " + invertido);
    }
}
Explicación: Extrae las decenas y unidades, y las invierte para formar el nuevo número.27. Mejor Nota de un Alumno
        java
public class MejorNota {
    public static void mejorNota(double nota1, double nota2, double nota3, double nota4) {
        double[] notas = {nota1, nota2, nota3, nota4};
        double mejor = nota1;
        for (double nota : notas) {
            if (nota > mejor) {
                mejor = nota;
            }
        }
        System.out.println("La mejor nota es: " + mejor);
    }

    public static void main(String[] args) {
        mejorNota(14, 15, 19, 12);
    }
}
Explicación: Guarda las notas en un arreglo y luego se compara la nota mayor.28. Aprobación de Curso
        java
public class AprobarReprobar {
    public static void aprobarReprobar(double calificacion1, double calificacion2, double calificacion3) {
        double promedio = (calificacion1 + calificacion2 + calificacion3) / 3;
        if (promedio >= 17) {
            System.out.println("Aprobado");
        } else {
            System.out.println("Reprobado");
        }
    }

    public static void main(String[] args) {
        aprobarReprobar(18, 17, 19);
    }
}
Explicación: Calcula el promedio y determina si el alumno aprueba o reprueba.29. Pago de Llantas
        java
public class PagoLlantas {
    public static void pagoLlantas(int cantidad) {
        int precioUnitario;
        if (cantidad < 5) {
            precioUnitario = 800;
        } else {
            precioUnitario = 700;
        }
        int total = cantidad * precioUnitario;
        System.out.println("Total a pagar: " + total);
    }

    public static void main(String[] args) {
        pagoLlantas(6);
    }
}
Explicación: Determina el precio unitario según la cantidad y calcula el total.30. Divisibilidad y Comparación de Números
        java
public class DivisibilidadComparacion {
    public static void divisibilidadComparacion(int num1, int num2) {
        if (num1 % num2 == 0) {
            System.out.println(num1 + " es divisible por " + num2);
        } else {
            System.out.println(num1 + " no es divisible por " + num2);
        }

        if (num2 % num1 == 0) {
            System.out.println(num2 + " es divisible por " + num1);
        } else {
            System.out.println(num2 + " no es divisible por " + num1);
        }

        if (num1 > num2) {
            System.out.println(num1 + " es mayor que " + num2);
        } else if (num2 > num1) {
            System.out.println(num2 + " es mayor que " + num1);
        } else {
            System.out.println("Ambos números son iguales");
        }

        if (num1 % 2 != 0 && num2 % 2 != 0) {
            System.out.println("Ambos son impares");
        } else {
            System.out.println("No ambos son impares");
        }
    }

    public static void main(String[] args) {
        divisibilidadComparacion(10, 5);
    }
}
Explicación: Realiza las verificaciones de divisibilidad, comparación y si ambos son impares.
Nivel Intermedio
Anagramas
        java
import java.util.Arrays;

public class Anagramas {
    public static boolean sonAnagramas(String palabra1, String palabra2) {
        palabra1 = palabra1.toLowerCase();
        palabra2 = palabra2.toLowerCase();
        if (palabra1.length() != palabra2.length()) {
            return false;
        }
        char[] palabra1Array = palabra1.toCharArray();
        char[] palabra2Array = palabra2.toCharArray();
        Arrays.sort(palabra1Array);
        Arrays.sort(palabra2Array);
        return Arrays.equals(palabra1Array, palabra2Array);
    }

    public static void main(String[] args) {
        String palabra1 = "congreso";
        String palabra2 = "sogrecon";
        if (sonAnagramas(palabra1, palabra2)) {
            System.out.println("Son anagramas");
        } else {
            System.out.println("No son anagramas");
        }
    }
}
Explicación: Convierte ambas palabras a minúsculas y verifica si tienen la misma longitud. Luego, las ordena y compara para ver si son iguales.2. Número Primo
java
public class NumeroPrimo {
    public static boolean esPrimo