package school.faang.sprint_2.streamapi1;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Processor {
    @NonNull List<Integer> numbers = new ArrayList<>();
    @NonNull List<String> words = new ArrayList<>();

    public int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(number -> number % 2 == 0).reduce(0, Integer::sum);
    }

    public int maxElement(List<Integer> numbers) {
        return numbers.stream().max(Integer::compare).get();
    }

    public double averageValue(List<Integer> numbers) {
        return numbers.stream().mapToInt(number -> number).average().getAsDouble();
    }

    public long findStringAmountStartedWith(List<String> words, char letter) {
        return words.stream().filter(word -> word.startsWith(letter + "")).count();
    }

    public List<String> findWordsContaintsSubstring(List<String> words, String substring) {
        return words.stream().filter(word -> word.contains(substring)).toList();
    }

    public List<String> sortListByLength(List<String> words) {
        return words.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public boolean compareListWithCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream().allMatch(condition::test);
    }

    public int findMinValueMoreThanTarget(List<Integer> numbers, int target) {
        return numbers.stream().filter(number -> number > target).min(Integer::compare).orElse(target);
    }

    public List<Integer> convertStringToIntByLength(List<String> words) {
        return words.stream().map(String::length).toList();
    }
}

