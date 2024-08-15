package faang.school.godbless.sprint2.streamAPI.BJS2_23057;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Sample data for demonstration
        List<Integer> numbers = List.of(10, 15, 22, 33, 46, 55, 62);
        List<String> strings = List.of("apple", "banana", "cherry", "date", "apricot", "blueberry");

        // Find the sum of even numbers
        int sumOfEvens = Tasks.findSumOfEvenFrom(numbers);
        System.out.println("Sum of even numbers: " + sumOfEvens); // Output: 140

        // Find the maximum integer
        int maxInt = Tasks.findMaxIntFrom(numbers);
        System.out.println("Maximum integer: " + maxInt); // Output: 62

        // Find the average of integers
        double averageInt = Tasks.findAverageIntFrom(numbers);
        System.out.println("Average integer: " + averageInt); // Output: 29.285714285714285

        // Find the count of strings starting with a specific character
        int countStartingWithA = Tasks.findLinesCountStartsWith('a', strings);
        System.out.println("Count of strings starting with 'a': " + countStartingWithA); // Output: 2

        // Find lines that contain a specific substring (starts with)
        List<String> linesContainingAp = Tasks.findLinesThatContains("ap", strings);
        System.out.println("Lines containing 'ap': " + linesContainingAp); // Output: [apple, apricot]

        // Get lines sorted by length
        List<String> sortedByLength = Tasks.getLinesSortedByLength(strings);
        System.out.println("Lines sorted by length: " + sortedByLength); // Output: [date, apple, cherry, banana, apricot, blueberry]

        // Check if all strings satisfy a predicate
        boolean allStartWithB = Tasks.checkListForStatement(strings, s -> s.startsWith("b"));
        System.out.println("All strings start with 'b': " + allStartWithB); // Output: false

        // Find the minimum element greater than a given number
        int minElementGreaterThan20 = Tasks.findMinElementGreaterThan(20, numbers);
        System.out.println("Minimum element greater than 20: " + minElementGreaterThan20); // Output: 22

        // Convert list of strings to list of their lengths
        List<Integer> lengths = Tasks.castStringToLenghtList(strings);
        System.out.println("Lengths of strings: " + lengths); // Output: [5, 6, 6, 4, 7, 9]
    }
}
