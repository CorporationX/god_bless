package bjs2_70797;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.rangeClosed(1, 6).boxed().toList();
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("The sum of even numbers: " + ListOperations.sumOfEvenNumbers(numbers));
        System.out.println("Max: " + ListOperations.maxValue(numbers));
        System.out.println("Average: " + ListOperations.averageValue(numbers));
        System.out.println("The number of lines starting with 'a': " + ListOperations.numberOfLines(strings, 'a'));
        System.out.println("Lines containing 'an': " + ListOperations.filterByLine(strings, "an"));
        System.out.println("Sorted by string length: " + ListOperations.sortByLength(strings));
        System.out.println("Are all the numbers even? " + ListOperations.allSatisfies(numbers, n -> n % 2 == 0));
        System.out.println("The smallest number is greater than 4: " + ListOperations.minWithCondition(numbers, 4));
        System.out.println("String lengths: " + ListOperations.convertFromStringsToLength(strings));
    }
}
