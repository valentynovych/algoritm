package checkBracket;

import java.util.Scanner;

public class BracketDemo {
    public static void main(String[] args) {
        CheckBracket checkBracket = new CheckBracket();
        Scanner scanner = new Scanner(System.in);
        boolean validation = false;

        while (true) {
            System.out.print("Enter your equation for validation bracket: ");
            String inlineString = scanner.nextLine();
            switch (inlineString) {
                case "Stop":
                    System.exit(0);
                default:
                    validation = checkBracket.parsing(inlineString);
                    System.out.println("Result validation bracket: " + validation);
                    break;
            }
        }
    }
}
