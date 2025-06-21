package school.faang.bjs280789;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    public static int sumEvenNumbers(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                sum += number;
            }
        }
        return sum;
    }

    public static int maxNumber(List<Integer> numbers) {
        int max = Integer.MIN_VALUE;
        for (Integer number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public static int midNumber(List<Integer> numbers) {
        double mid = 0;
        for (Integer number : numbers) {
            mid += number;
        }
        return (int) mid;
    }
}
