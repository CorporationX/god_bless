package faang.school.godbless.stream.api;

import java.util.List;

public class StreamsInt {
    public static int CalculatesSumEvenNumbers(List<Integer> integerList) {
        return integerList.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(number -> number)
                .sum();
    }

    public static int findMaxValue(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(number -> number)
                .max()
                .orElse(0);
    }

    public static double findAverageValue(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(m -> m)
                .average()
                .orElse(0);
    }
}
