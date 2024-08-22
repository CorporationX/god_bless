package faang.school.godbless;

import java.util.List;

public class TheSumOfEvenNumbers {
    public static Integer sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(x -> x)
                .sum();
    }
}