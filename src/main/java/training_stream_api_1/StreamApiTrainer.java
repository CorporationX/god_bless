package training_stream_api_1;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamApiTrainer {

    public static int getSumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int getMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    public static double getAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(x -> x)
                .average()
                .orElse(0);
    }

    public static int getCountStringsStartsWith(List<String> strings, String prefix) {
        return (int) strings.stream()
                .filter(x -> x.startsWith(prefix))
                .count();
    }

    public static List<String> filterBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(x -> x.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean isAllMatch(List<Integer> list,
                                     Predicate<Integer> predicate) {
        return list.stream()
                .allMatch(predicate);
    }

    public static int getSmallestGreaterThen(List<Integer> numbers,
                                             int target) {
        return numbers.stream()
                .filter(x -> x > target)
                .min(Integer::compareTo)
                .orElseThrow(() ->
                        new NoSuchElementException("В списке нет элемента, удовлетворяющего условию")
                );
    }

    public static List<Integer> mapToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }

}
