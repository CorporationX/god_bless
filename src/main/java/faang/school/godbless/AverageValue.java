package faang.school.godbless;

import java.util.List;
import java.util.OptionalDouble;

public class AverageValue {
    public static Double findAverageValue(List<Integer> numbers) {
        OptionalDouble average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average();
        return average.orElse(0.0);
    }
}