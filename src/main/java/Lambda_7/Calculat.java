package Lambda_7;

import java.util.List;

public class Calculat {
    public int calculate(List<Integer> list, Calculator calculator) {
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
