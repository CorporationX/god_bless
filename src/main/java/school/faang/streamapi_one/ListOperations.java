package school.faang.streamapi_one;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> list) {
        int sum = list.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        return sum;
    }

    public static int findMax(List<Integer> list) {
        return list.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("LIst is empty"));
    }
}
