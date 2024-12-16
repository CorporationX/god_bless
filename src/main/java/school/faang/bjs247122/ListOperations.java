package school.faang.bjs247122;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, (integer, integer1) -> integer + integer1);
    }

    public static int maxElement(List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new NoSuchElementException("List can not be empty or null"));
    }

    public static double averageNum(List<Integer> numbers) {
        return numbers
                .stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("List can not be empty or null"));
    }

    public static int countWordsWithChar(List<String> stringList, char symbol) {
        long wordsCount = stringList.stream()
                .filter(word -> !word.isEmpty()
                        && Character.toLowerCase(word.charAt(0)) == Character.toLowerCase(symbol))
                .count();
        return Math.toIntExact(wordsCount);
    }

    public static List<String> containsSubstring(List<String> strings, String string) {
        return strings
                .stream()
                .filter(word -> word.toLowerCase().contains(string.toLowerCase()))
                .toList();
    }

    public static List<String> sortedWordByLength(List<String> strings) {
        return strings.stream()
                .sorted((word1, word2) -> word1.length() - word2.length())
                .toList();
    }

    public static boolean filterListByCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int num) {
        if (numbers == null || numbers.isEmpty()) {
            throw new NoSuchElementException("List can not be empty or null");
        }
        return numbers.stream()
                .filter(currentNum -> currentNum > num)
                .findFirst()
                .get();
    }

    public static List<Integer> transformationWordInLength(List<String> strings) {
        return strings.stream()
                .map(string -> string.length())
                .toList();
    }
}
