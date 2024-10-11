package school.faang;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringAndNumberOperator operator = new StringAndNumberOperator();
        List<Integer> numbers = List.of(23, 1, 45, 65, 1, 3, 4, 5, 1, 5, 87, 9, 67, 6, 5, 11);
        List<String> strings = List.of("Territory", "Sam", "German", "Sakura", "Dmitry", "Svinya", "Salo", "Fu");

        System.out.println("Sum of even numbers: " + operator.sumEvenNumbers(numbers));
        System.out.println("Max value: " + operator.findMaxValue(numbers));
        System.out.println("Average value: " + operator.findAverageValue(numbers));
        System.out.println("Count of strings starting with 'S': " + operator.findCountOfStrings(strings, 'S'));
        System.out.println("Strings containing the substring 'Sa': " + operator.filterSubstring(strings, "Sa"));
        System.out.println("Sorted by string length: " + operator.sortByLength(strings));
        System.out.println("Are all numbers less than 90? " + operator.isSatisfying(numbers, num -> num < 90));
        System.out.println("The smallest number greater than 10: " + operator.findSmallestGreaterThanGivenValue(numbers, 10));
        System.out.println("String lengths: " + operator.convertToListOfLengths(strings));
    }
}
