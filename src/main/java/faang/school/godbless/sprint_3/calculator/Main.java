package faang.school.godbless.sprint_3.calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        int first = sum(list);
        int second = product(list);
        System.out.println(first);
        System.out.println(second);
    }

    public static int calculate(List<Integer> values, Calculator calculator) throws IllegalArgumentException {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }

        int result = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            result = calculator.calculate(result, values.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (first, second) -> first * second);
    }

    public static int sum(List<Integer> values) {
        return calculate(values, (Integer::sum));
    }
}
