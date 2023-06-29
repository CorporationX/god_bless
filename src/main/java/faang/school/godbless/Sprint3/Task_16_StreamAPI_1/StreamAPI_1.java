package faang.school.godbless.Sprint3.Task_16_StreamAPI_1;

import java.util.List;

public class StreamAPI_1 {
    public static int sumOfEvenNumbers (List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
