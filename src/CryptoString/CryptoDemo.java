package CryptoString;

import java.util.Scanner;

public class CryptoDemo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select option\n" + "1 - encrypt text\n" + "2 - decrypt text");
            int option = scanner.nextInt();
            if (option == 1 || option == 2) {
                choseOption(option);
            } else {
                System.out.println("Enter option number 1 or 2");
            }
        }
    }

    public static void choseOption(int option) {
        CryptoString cryptoString = new CryptoString();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input key: ");
        String key = scanner.nextLine();

        System.out.print("Input text: ");
        String text = scanner.nextLine();

        String result = option == 1 ? cryptoString.crypt(text, key)
                : option == 2 ? cryptoString.decrypt(text, key)
                : "";
        System.out.println(result);
        System.out.println();

    }
}
