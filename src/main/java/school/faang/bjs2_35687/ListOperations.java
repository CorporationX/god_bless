package school.faang.bjs2_35687;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ListOperations {
    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(integer -> (integer % 2 == 0))
                .reduce(0, Integer::sum);
    }

    public static int findMaxElement(List<Integer> numbers) {
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        if (max.isEmpty()) {
            throw new NoSuchElementException("no elements found");
        }
        return max.get();
    }

    public static double findAverageOfNumbers(List<Integer> numbers) {
        double quantity = numbers.size();
        double sumNumbers = numbers.stream().reduce(0, Integer::sum);
        return sumNumbers / quantity;
    }

    public static int countStringsStartingWith(List<String> strings, char startSymbol) {
        return (int) strings.stream()
                .filter(s -> s.startsWith(String.valueOf(startSymbol)))
                .count();
    }
}
