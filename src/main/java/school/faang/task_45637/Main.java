package school.faang.task_45637;

import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        System.out.println(sum(list));
        System.out.println(product(list));
    }

    public static int calculate(List<Integer> list, Calculator calculator) {
        if (Objects.isNull(list) || list.isEmpty()) {
            throw new IllegalArgumentException("list invalid");
        }

        int result = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            result = calculator.calc(result, list.get(i));
        }

        return result;
    }

    public static int product(List<Integer> list) {
        return calculate(list, (a, b) -> a * b);
    }

    public static int sum(List<Integer> list) {
        return calculate(list, Integer::sum);
    }
}
