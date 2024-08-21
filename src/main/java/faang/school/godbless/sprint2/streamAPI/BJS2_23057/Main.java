package faang.school.godbless.sprint2.streamAPI.BJS2_23057;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(10, 15, 22, 33, 46, 55, 62);
        List<String> strings = List.of("apple", "banana", "cherry", "date", "apricot", "blueberry");

        int sumOfEvens = Tasks.findSumOfEvenFrom(numbers);
        System.out.println("Sum of even numbers: " + sumOfEvens);

        int maxInt = Tasks.findMaxIntFrom(numbers);
        System.out.println("Maximum integer: " + maxInt);

        double averageInt = Tasks.findAverageIntFrom(numbers);
        System.out.println("Average integer: " + averageInt);

        int countStartingWithA = Tasks.findLinesCountStartsWith('a', strings);
        System.out.println("Count of strings starting with 'a': " + countStartingWithA);

        List<String> linesContainingAp = Tasks.findLinesThatContains("ap", strings);
        System.out.println("Lines containing 'ap': " + linesContainingAp);

        List<String> sortedByLength = Tasks.getLinesSortedByLength(strings);
        System.out.println("Lines sorted by length: " + sortedByLength);

        boolean allStartWithB = Tasks.checkListForStatement(strings, s -> s.startsWith("b"));
        System.out.println("All strings start with 'b': " + allStartWithB);

        int minElementGreaterThan20 = Tasks.findMinElementGreaterThan(20, numbers);
        System.out.println("Minimum element greater than 20: " + minElementGreaterThan20);

        List<Integer> lengths = Tasks.castStringToLenghtList(strings);
        System.out.println("Lengths of strings: " + lengths);
    }
}
