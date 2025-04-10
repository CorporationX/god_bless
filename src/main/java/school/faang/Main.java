package school.faang;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        try {
            int[] reversed = Example.reverse(numbers);
            System.out.println("Original: " + Arrays.toString(numbers));
            System.out.println("Reversed: " + Arrays.toString(reversed));
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}