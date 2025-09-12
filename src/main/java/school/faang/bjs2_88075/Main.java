package school.faang.bjs2_88075;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "banana");

        System.out.println("Sum even numbers: " + ListOperations.sumEvenNumbers(numbers));
        System.out.println("Max number: " + ListOperations.maxElement(numbers));
        System.out.println("Average value numbers: " + ListOperations.averageValueNumbers(numbers));
        System.out.println("Number special lines: " + ListOperations.numberSpecialLines(strings, 'b'));
        System.out.println("String filter: " + ListOperations.stringFilter(strings, "ba"));
        System.out.println("Sorting by length: " + ListOperations.sortingByLength(strings));
    }
}