package school.faang.s2_stream_api1;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.Comparator;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException());
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream().
                mapToInt(Integer::intValue).
                average()
                .orElse(0.0);
    }

    public static long countStringsStartingWith(List<String> strings, char c) {
        return strings.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == c)
                .count();
    }

    public static List<String> filterBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

   public static int  findMinGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(x -> x > threshold)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Нет элементов больше " + threshold));
   }

   public static List<Integer> mapToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
   }
}
