package school.faang;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        int result = 0;
        Optional<Integer> sum = numbers.stream()
                                       .filter(x -> x % 2 == 0)
                                       .reduce((x, y) -> x * y);
        if (sum.isPresent()) {
            result = sum.get();
        }

        return result;
    }



    public static int findMax(List<Integer> numbers)
                                               throws NoSuchElementException {
        Optional<Integer> result = numbers.stream()
                                          .max(Integer::compare);

        if (!result.isPresent()) {
            throw new NoSuchElementException("Элемент не найден");
        }
        return result.get();
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                      .collect(Collectors.averagingInt(Integer::intValue));
    }

    public static int countStringsStartingWith(List<String> strings, char c) {
        long quantity = strings.stream()
                               .filter(x -> x.startsWith(String.valueOf(c)))
                               .count();

        return (int) quantity;
    }

    public static List<String> filterStringsContainingSubstring(
                                     List<String> strings, String substring) {
        return strings.stream()
                      .filter(x -> x.contains(substring))
                      .collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                      .sorted(Comparator.comparingInt(String::length))
                      .collect(Collectors.toList());
    }

    public static boolean allMatchCondition(List<Integer> numbers,
                                                Predicate<Integer> condition) {
        return numbers.stream()
                      .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int boundary)
                                                throws NoSuchElementException {

        Optional<Integer> result = numbers.stream()
                                          .filter(x -> x > boundary)
                                          .min(Integer::compare);

        if (!result.isPresent()) {
            throw new NoSuchElementException(
                            "В списке нет элементов больше, чем " + boundary);
        }
        return result.get();
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                      .map(String::length)
                      .collect(Collectors.toList());
    }
}
