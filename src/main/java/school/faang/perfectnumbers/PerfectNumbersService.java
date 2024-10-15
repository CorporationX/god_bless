package school.faang.perfectnumbers;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumbersService {
    public static List<Integer> getPerfectNumbers(int fromNumber, int toNumber) {
        List<Integer> result = new ArrayList<>();
        for (int i = fromNumber; i <= toNumber; i++) {
            int sumOfDivisors = 0;
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    sumOfDivisors += j;
                }
            }
            if (i == sumOfDivisors) {
                result.add(i);
            }
        }
        return result;
    }
}
