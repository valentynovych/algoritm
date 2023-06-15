package Search;

import java.util.Random;
import java.util.Scanner;

public class SearchDemo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter an array size: ");

        int size = scanner.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(200);
        }
        Search.quickSort(array, 0, size - 1);
        System.out.println("Fill array:");

        for (int elem : array) {
            if (elem == array[0]) {
                System.out.print("[ ");
            }
            System.out.print(elem + ", ");
            if (elem == array[size - 1]) {
                System.out.print(" ]");
            }
        }
        System.out.println();
        System.out.print("Enter element for search our index: ");
        int elemToSearch = scanner.nextInt();
        Search.binarySearch(array, elemToSearch);
    }
}