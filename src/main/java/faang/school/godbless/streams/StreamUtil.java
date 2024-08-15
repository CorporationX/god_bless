package faang.school.godbless.streams;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StreamUtil {

    public static int getSumOddNumbers(@NonNull List<Integer> numbers) {
        checkIsListNotEmptyOrElseThrowError(numbers);

        return numbers.stream()
                .mapToInt(n -> n)
                .filter(n -> n % 2 == 0)
                .sum();
    }

    public static int getMaxInListNumbers(@NonNull List<Integer> numbers) {
        checkIsListNotEmptyOrElseThrowError(numbers);

        return numbers.stream()
                .mapToInt(n -> n)
                .max()
                .getAsInt();
    }

    public static double getAverageSumInListNumbers(@NonNull List<Integer> numbers) {
        checkIsListNotEmptyOrElseThrowError(numbers);

        return numbers.stream()
                .mapToInt(n -> n)
                .average()
                .getAsDouble();
    }

    public static int findHowManySentencesStartsWithLetter(List<String> sentences, Character letter) {
        return (int) sentences.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .count();
    }

    public static List<String> filterListSentencesContainsSubstring(List<String> sentences, CharSequence letter) {
        return sentences.stream()
                .filter(s -> s.contains(letter))
                .toList();
    }

    public static List<String> sortListSentencesByLength(List<String> sentences) {
        return sentences.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean checkIfAllElementsSatisfyCondition(List<String> sentences, Predicate<String> filter) {
        return sentences.size() == sentences.stream().filter(filter).count();
    }

    public static int findMinNumberInListByFilter(List<Integer> numbers, Predicate<Integer> filter) {
        return numbers.stream()
                .filter(filter)
                .min(Comparator.naturalOrder())
                .orElseThrow(() -> new RuntimeException("NOT FOUND"));
    }

    public static List<Integer> castListStringToListIntegersByTheirLength(List<String> sentences) {
        return sentences.stream()
                .map(String::length)
                .toList();
    }

    private static void checkIsListNotEmptyOrElseThrowError(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("List of numbers can't be empty");
        }
    }
}
