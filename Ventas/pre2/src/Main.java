public class Main {
    public static void printFibonacci(int n) {
        if (n <= 0) {
            System.out.println("introduce un numero positivo");
            return;
        }
        int a = 0, b = 1;
        System.out.print(a);
        if (n > 1) {
            System.out.print(", " + b);
        }
        for (int i = 2; i < n; i++) {
            int next = a + b;
            System.out.print(", " + next);
            a = b;
            b = next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test cases from the image
        printFibonacci(5);
        printFibonacci(10);
        printFibonacci(20);
    }
}