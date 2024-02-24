package faang.school.godbless.streamapi1;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Stream {
    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static Optional<Integer> findMaxNumber(List<Integer> maxNumber) {
        return maxNumber.stream()
                .max(Integer::compareTo);
    }

    public static double findAverageNumbers(List<Integer> average) {
        return average.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(-1);
    }

    public static long countStringsWithStartingCharacter(List<String> words, char character) {
        return words.stream()
                .filter(word -> word != null && !word.isEmpty() && word.startsWith(String.valueOf(character)))
                .count();
    }

    public static long filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(word -> word != null && !word.isEmpty() && word.contains(substring))
                .count();
    }

    public static List<String> sortStringsByLength(List<String> wordsOfList) {
        return wordsOfList.stream()
                .sorted(Comparator.comparingInt(String::length))  //(a, b) -> Integer.compare(a.length(), b.length())
                .collect(Collectors.toList());
    }

    public static boolean checkContdition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static Optional<Integer> findMin(List<Integer> minElement, int num) {
        return minElement.stream()
                .filter(n -> n > num)
                .min(Integer::compareTo);
    }

    public static List<Integer> transformListOfWord(List<String> lengthOfwords) {
        return lengthOfwords.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
