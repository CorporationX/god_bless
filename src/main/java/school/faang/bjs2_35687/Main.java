package school.faang.bjs2_35687;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println(ListOperations.sumEvenNumbers(numbers));
        System.out.println(ListOperations.findMaxElement(numbers));
        System.out.println(ListOperations.findAverageOfNumbers(numbers));
    }
}
