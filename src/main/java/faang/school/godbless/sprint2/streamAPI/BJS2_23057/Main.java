package faang.school.godbless.sprint2.streamAPI.BJS2_23057;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(10, 15, 22, 33, 46, 55, 62);
        List<String> strings = List.of("apple", "banana", "cherry", "date", "apricot", "blueberry");

        System.out.println("Sum of even numbers: " + Tasks.findSumOfEvenFrom(numbers));

        System.out.println("Maximum integer: " + Tasks.findMaxIntFrom(numbers));

        System.out.println("Average integer: " + Tasks.findAverageIntFrom(numbers));

        System.out.println("Count of strings starting with 'a': " + Tasks.findLinesCountStartsWith('a', strings));

        System.out.println("Lines containing 'ap': " + Tasks.findLinesThatContains("ap", strings));

        System.out.println("Lines sorted by length: " + Tasks.getLinesSortedByLength(strings));

        System.out.println("All strings start with 'b': " + Tasks.checkListForStatement(strings, s -> s.startsWith("b")));

        System.out.println("Minimum element greater than 20: " + Tasks.findMinElementGreaterThan(20, numbers));

        System.out.println("Lengths of strings: " + Tasks.castStringToLenghtList(strings));
    }
}
