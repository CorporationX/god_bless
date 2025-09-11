package school.faang.bjs2_88075;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Sum even numbers: " + ListOperations.sumEvenNumbers(numbers));
        System.out.println("Max number: " + ListOperations.maxElement(numbers));
    }
}