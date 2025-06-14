package school.faang.stream1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StreamLogic {
    public static int sumOfEvenElement(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, (area, number) -> area + number);
    }

    public static int maxElement(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("List is empty"));
    }

    public static double averageNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new RuntimeException("List is empty"));
    }

    public static long countLinesStartingChar(List<String> lines, char symbol) {
        return lines.stream()
                .filter(line -> symbol == line.charAt(0))
                .toList()
                .size();
    }

    public static List<String> stringsWithSubstring(List<String> lines, String substring) {
        return lines.stream()
                .filter(line -> line.contains(substring))
                .toList();
    }

    public static List<String> sortedLines(List<String> lines) {
        return lines.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean checkingCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate::test);
    }

    public static int findBiggerThan(List<Integer> numbers, int entryNumber) {
        return numbers.stream()
                .filter(number -> number > entryNumber)
                .min(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("there are no elements bigger than " + entryNumber));
    }

    public static List<Integer> linesInNumbers(List<String> lines) {
        return lines.stream()
                .map(line -> Integer.valueOf(line.length()))
                .toList();
    }
}
