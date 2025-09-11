package school.faang.bjs2_88075;

import java.util.List;
import java.util.NoSuchElementException;

public class ListOperations {

    public static int sumEvenNumbers(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }

        return numbers.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int maxElement(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("List is empty"));
    }

    public static double averageValueNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("List is empty"));
    }

    public static long numberSpecialLines(List<String> fruit, char sign) {
        return fruit.stream()
                .filter(word -> word.charAt(0) == sign)
                .count();
    }
}