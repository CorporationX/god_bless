package bjs2_57133;

import java.util.Iterator;
import java.util.List;

public class CalculationRunner {
    public static int calculate(List<Integer> items, Calculator<Integer> calculator) {
        if (items.isEmpty()) {
            return 0;
        }

        int accumulator = items.get(0);

        Iterator<Integer> iskipFirstIerator = items.stream().skip(1).iterator();
        while (iskipFirstIerator.hasNext()) {
            accumulator = calculator.calculate(accumulator, iskipFirstIerator.next());
        }

        return accumulator;
    }
}
