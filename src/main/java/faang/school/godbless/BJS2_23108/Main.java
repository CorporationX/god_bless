package faang.school.godbless.BJS2_23108;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "apricot", "kiwi");

        System.out.println("Sum of even numbers: " + StreamApiFirst.sum(numbers));
        System.out.println("Max element: " + StreamApiFirst.findMax(numbers));
        System.out.println("Average: " + StreamApiFirst.findAverage(numbers));
        System.out.println("Count of strings starting with 'a': " + StreamApiFirst.findStringThatStartWith(strings, "a"));
        System.out.println("Filtered strings: " + StreamApiFirst.filterStringThatContain(strings, "ap"));
        System.out.println("Sorted strings by length: " + StreamApiFirst.sortStringByLength(strings));
        System.out.println("All strings are having s: " + StreamApiFirst.checkingString(strings, "s"));
        System.out.println("Min greater than 2: " + StreamApiFirst.findMinElementThatBiggerThan(numbers, 2));
        System.out.println("Length of strings: " + StreamApiFirst.transformStringToLength(strings));
    }
}
