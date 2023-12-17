package Lambda_7;

import java.util.List;

public class Calculation {
    public int calculate(List<Integer> list, Calculator calculator) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("invalid input data");
        }
        int result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result = calculator.add(result, list.get(i));
        }
        return result;
    }

    public int sum(List list) {
        return calculate(list, (a, b) -> a + b);
    }

    public int product(List list) {
        return calculate(list, (a, b) -> a * b);
    }
}
