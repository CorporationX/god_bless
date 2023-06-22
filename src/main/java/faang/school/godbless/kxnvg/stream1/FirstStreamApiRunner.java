package faang.school.godbless.kxnvg.stream1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class FirstStreamApiRunner {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(num -> num % 2 == 0).reduce(0, Integer::sum);
    }

    public static int maxElement(List<Integer> numbers) {
        return numbers.stream().max(Comparator.naturalOrder()).orElseThrow();
    }

    public static double averageValue(List<Integer> numbers) {
        return numbers.stream().mapToInt(x -> x).average().orElse(Double.NaN);
    }

    public static int searchQuantityLineStartingWithChar(List<String> strings, char ch) {
        return (int) strings.stream().filter(line -> line.startsWith(String.valueOf(ch))).count();
    }

    public static List<String> filterLineInList(List<String> strings, String filterLine) {
        return strings.stream().filter(line -> line.contains(filterLine)).toList();
    }

    public static List<String> sortByLineLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparing(String::length)).toList();
    }

    public static <T> boolean conditionCheck(List<T> list, Predicate<T> predicate) {
        return list.stream().allMatch(predicate);
    }

    public static int findMinValueMoreThen(List<Integer> numbers, int value) {
        return numbers.stream().filter(x -> x > value).min(Comparator.naturalOrder()).orElseThrow();
    }

    public static List<Integer> transformListOfStringInListOfInteger(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }
}
