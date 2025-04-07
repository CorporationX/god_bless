package school.faang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final List<Integer> inversionNumbers = new ArrayList<>();

        for (int i = numbers.length - 1; i >= 0; i--) {
            inversionNumbers.add(numbers[i]);
        }

        System.out.println(Arrays.toString(numbers));
        System.out.println(inversionNumbers);
    }
}
