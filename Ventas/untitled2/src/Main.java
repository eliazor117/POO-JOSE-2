public class IsPalindrome {
    public static boolean isPalindrome(String text) {
        // Remove spaces and convert to lowercase
        String cleaned = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c != ' ') {
                cleaned += Character.toLowerCase(c);
            }
        }

        // Check if palindrome
        int left = 0;
        int right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        // Test cases from the image
        System.out.println(isPalindrome("Anita lava la tina")); // Output: true
        System.out.println(isPalindrome("Luz azul")); // Output: true
        System.out.println(isPalindrome("Hola mundo")); // Output: false
    }
}





public class Fibonacci {
    public static void printFibonacci(int n) {
        if (n <= 0) {
            System.out.println("Please enter a positive number.");
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
        printFibonacci(5); // Output: 0, 1, 1, 2, 3
        printFibonacci(10); // Output: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
        printFibonacci(20); // Output: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181
    }
}