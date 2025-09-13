package bjs288319;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Sum even nums: " + Calculator.sumOfEvenNumbers(numbers));
        System.out.println("Max: " + Calculator.findMax(numbers));
        System.out.println("Average: " + Calculator.findAverage(numbers));
        System.out.println("Amount strs start with 'a': " + Calculator.findStringAmountsStartsWith(strings, 'a'));
        System.out.println("Strings contain 'an': " + Calculator.findStringsHasSubstring(strings, "an"));
        System.out.println("Sorted by length: " + Calculator.sortStringsPerLength(strings));
        System.out.println("All nums are even? " + Calculator.checkNums(numbers, n -> n % 2 == 0));
        System.out.println("Min bigger than 4: " + Calculator.findMinNumBiggerThan(numbers, 4));
        System.out.println("Strings length: " + Calculator.transformStringsIntoLengths(strings));
    }
}
