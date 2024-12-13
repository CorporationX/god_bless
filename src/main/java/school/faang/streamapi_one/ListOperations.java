package school.faang.streamapi_one;

import java.util.List;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> list) {
        int sum = list.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        return sum;
    }
}
