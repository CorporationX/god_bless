package stream.practiceone;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 1, 2, 7, 4, 9);
        List<String> lines = List.of("a", "bbbete", "ccc", "abc", "bcdt", "ac", "tcd");

        System.out.println(StreamPractice.sumNumbers(numbers));
        System.out.println(StreamPractice.maxNumber(numbers));
        System.out.println(StreamPractice.averNumber(numbers));
        System.out.println(StreamPractice.specificLetter(lines, "a"));
        System.out.println(StreamPractice.filterLines(lines, "cd"));
        System.out.println(StreamPractice.listSort(lines));
        System.out.println(StreamPractice.listCondition(lines, s -> s.length() > 3));
        System.out.println(StreamPractice.minElemInList(numbers, 4));
        System.out.println(StreamPractice.lineToLength(lines));
    }
}
