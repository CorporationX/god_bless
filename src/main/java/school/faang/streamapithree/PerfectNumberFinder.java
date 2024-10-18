package school.faang.streamapithree;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PerfectNumberFinder {

    public static List<Integer> findPerfectNumbersInRange(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(PerfectNumberFinder::isPerfect)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isPerfect(int number) {
        int sum = IntStream.rangeClosed(1, number / 2)
                .filter(i -> number % i == 0)
                .sum();

        return sum == number;
    }
}
