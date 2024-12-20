package school.faang.bjs_46821;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PerfectNumber {

    public static boolean isPerfect(int number) {
        Set<Integer> dividerSet = dividers(number);
        int sum = dividerSet.stream()
                .mapToInt(Integer::intValue)
                .sum();
        return Objects.equals(sum, number);
    }

    private static Set<Integer> dividers(int number) {
        return IntStream.rangeClosed(1, number / 2)
                .filter(n -> number % n == 0)
                .boxed()
                .collect(Collectors.toSet());
    }
}
