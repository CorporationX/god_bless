package school.faang.bjs247027;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Utilities {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        if (numbers == null) {
            return 0;
        }

        return numbers.stream().filter(number -> number % 2 == 0).reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> numbers) {
        if (numbers == null) {
            return 0;
        }
        return numbers.stream().max(Integer::compare);
    }
}
