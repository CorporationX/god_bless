package school.faang.bjs2_88251;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

@Slf4j
public class ListOfOperations {

    public Integer sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .reduce(Integer::sum)
                .orElseThrow(() -> new RuntimeException("Нет четных чисел для суммирования"));
    }

    public Integer maxNumber(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compare)
                .orElseThrow(() -> new RuntimeException("Список оказался пуст"));
    }

    public Double avgNumbersValue(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElseThrow(() -> new RuntimeException("Список оказался пуст"));
    }

    public Long wordsStartingWith(List<String> words, Character ch) {
        return words.stream()
                .filter(word -> word.charAt(0) == ch)
                .count();
    }

    public List<String> containsSubstring(List<String> words, String substring) {
        return words.stream()
                .filter(word -> word.contains(substring))
                .toList();
    }

    public List<String> sortedByLength(List<String> words) {
        return words.stream()
                .sorted(Comparator.comparing(String::length)
                        .thenComparing(String::compareTo))
                .toList();
    }

    public Boolean isAllMatch(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public Integer minBiggerThan(List<Integer> numbers, int minValue) {
        return numbers.stream()
                .filter(integer -> integer > minValue)
                .min(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("Числа меньше, чем " + minValue + " не нашлось"));

    }

    public List<Integer> convertToLength(List<String> words) {
        return words.stream()
                .map(String::length)
                .toList();
    }
}
