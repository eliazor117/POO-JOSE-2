import java. util.Scanner;
class pre1 {
    static int nombre;
    public static boolean isPalindrome(String text) {
        Scanner sc = new Scanner(System.in);

        System.out.print("introduce valor de entrada");
        nombre = sc.nextInt();

        String valor = "";

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            nombre = c;
            if (c != ' ') {
                valor += Character.toLowerCase(c);
            }
        }
        int left = 0;
        int right = valor.length() - 1;
        while (left < right) {
            if (valor.charAt(left) != valor.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println();

    }
}

