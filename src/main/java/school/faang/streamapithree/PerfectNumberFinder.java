package school.faang.streamapithree;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumberFinder {

    public static List<Integer> findPerfectNumbersInRange(int start, int end) {
        List<Integer> perfectNumbers = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            if (isPerfect(i)) {
                perfectNumbers.add(i);
            }
        }
        return perfectNumbers;
    }

    private static boolean isPerfect(int number) {
        int sum = 0;

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number;
    }
}

