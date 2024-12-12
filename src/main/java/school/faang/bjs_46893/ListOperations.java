package school.faang.bjs_46893;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumEvenNumbers(List<Integer> numbers) {
        AtomicInteger sum = new AtomicInteger();
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(sum::addAndGet);
        return sum.get();
    }

    public static int maxNumbers(List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.comparing(Integer::valueOf))
                .orElseThrow(() -> new IllegalArgumentException("No number found"));
    }

    public static double avgNumber(List<Integer> numbers) {
        AtomicInteger sum = new AtomicInteger();
        numbers.forEach(sum::addAndGet);
        return (double) sum.get() / numbers.size();
    }


    public static int countStartWith(List<String> strings, char letter) {
        return (int) strings.stream()
                .filter(string -> string.startsWith(String.valueOf(letter)))
                .count();
    }

    public static List<String> containsSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        strings.sort(Comparator.comparingInt(String::length));
        return strings;
    }

    public static boolean validate(List<Integer> numbers, Predicate<Integer> predicate) {
        long countFounded = numbers.stream()
                .filter(predicate)
                .count();
        return countFounded == numbers.size();
    }

    public static int findMinGreatThan(List<Integer> numbers, int comparedNumber) {
        return numbers.stream()
                .filter(number -> number > comparedNumber)
                .min(Comparator.comparing(Integer::valueOf))
                .orElseThrow(() -> new IllegalArgumentException("No number found"));
    }

    public static List<Integer> getStringsLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }

}
