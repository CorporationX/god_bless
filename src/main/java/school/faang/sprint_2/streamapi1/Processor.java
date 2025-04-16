package school.faang.sprint_2.streamapi1;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

@Setter
@Getter
public class Processor {
    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int maxElement(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compare)
                .orElseThrow(NoSuchElementException::new);
    }

    public static double averageValue(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(number -> number)
                .average().orElseThrow(NoSuchElementException::new);
    }

    public static long findStringAmountStartedWith(List<String> words, char letter) {
        return words.stream()
                .filter(word -> word
                        .startsWith(letter + ""))
                .count();
    }

    public static List<String> findWordsContaintsSubstring(List<String> words, String substring) {
        return words.stream()
                .filter(word -> word
                        .contains(substring))
                .toList();
    }

    public static List<String> sortListByLength(List<String> words) {
        return words.stream()
                .sorted(Comparator
                        .comparingInt(String::length))
                .toList();
    }

    public static boolean compareListWithCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinValueGreaterTarget(List<Integer> numbers, int target) {
        return numbers.stream()
                .filter(number -> number > target)
                .min(Integer::compare)
                .orElseThrow(NoSuchElementException::new);
    }

    public static List<Integer> convertStringToIntByLength(List<String> words) {
        return words.stream()
                .map(String::length)
                .toList();
    }
}