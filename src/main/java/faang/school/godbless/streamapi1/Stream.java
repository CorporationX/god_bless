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
        return Optional.of(maxNumber.stream()
                .max(Integer::compareTo)
                .orElse(-1));
    }

    public static OptionalDouble findAverageNumbers(List<Integer> average) {
        return OptionalDouble.of(average.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(-1));
    }

    public static long countNumber(List<String> words, char character) {
        return words.stream()
                .filter(word -> !word.isEmpty() && word.startsWith(String.valueOf(character)))
                .count();
    }

    public static long filterWords(List<String> wordsOfList, String substring) {
        return wordsOfList.stream()
                .filter(word -> !word.isEmpty() && word.contains(substring))
                .count();
    }

    public static List<String> sortWords(List<String> wordsOfList) {
        return wordsOfList.stream()
                .sorted((a, b) -> Integer.compare(a.length(), b.length()))
                .collect(Collectors.toList());
    }

    public static boolean checkContdition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static Optional<Integer> findMin(List<Integer> minElement, int num) {
        return Optional.of(minElement.stream()
                .filter(n -> n > num)
                .min(Integer::compareTo)
                .orElse(-1));
    }

    public static List<Integer> transformListOfWord(List<String> lengthOfwords) {
        return lengthOfwords.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
