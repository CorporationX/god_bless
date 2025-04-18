package school.faang.training_stream;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Training {

    public static int sumList(List<Integer> numberList) {
        return numberList.stream()
                .filter(a -> a % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static OptionalInt maxValue(List<Integer> numberList) {
        return numberList.stream()
                .mapToInt(Integer::intValue)
                .max();
    }

    public static OptionalDouble middleValue(List<Integer> numberList) {
        return numberList.stream()
                .mapToInt(a -> a).average();
    }

    public static long startOfLine(List<String> wordList, char index) {
        return wordList.stream()
                .filter(a -> a.charAt(0) == index && !a.isEmpty())
                .count();
    }

    public static List<String> substringString(List<String> wordsList, String word) {
        return wordsList.stream()
                .filter(s -> s.contains(word))
                .collect(Collectors.toList());
    }

    public static List<String> lengthString(List<String> wordList) {
        return wordList.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean sortedByIf(List<Integer> numberList, Predicate<Integer> filter) {
        return numberList.stream()
                .anyMatch(filter);
    }

    public static int minMaxNumber(List<Integer> numberList, int number) {
        return numberList.stream()
                .filter(a -> a > number)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Не нашел больше" + number));
    }

    public static List<Integer> converter(List<String> wordString) {
        return wordString.stream()
                .map(String::length)
                .toList();
    }
}
