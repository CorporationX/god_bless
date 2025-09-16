package school.faang.bjs2_88187;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> listOfNumbers) {
        Stream<Integer> evenNumbers = listOfNumbers.stream();
        return evenNumbers
                .mapToInt(Integer::intValue)
                .filter(n -> n % 2 == 0)
                .sum();
    }

    public static int findMax(List<Integer> listOfNumbers) {
        Stream<Integer> stream = listOfNumbers.stream();
        Optional<Integer> minNumber = stream
                .max(Comparator.naturalOrder());
        return minNumber.orElseThrow(() -> new NoSuchElementException("Пусто"));
    }
}
