package faang.school.godbless.calculator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        numbers.add(1);
        numbers.add(Integer.MAX_VALUE);
        numbers.add(3);
        numbers.add(4);

        System.out.println(sum(numbers));
        System.out.println(product(numbers));
    }

    public static long calculate(List<Integer> nums, Calculator<Long> calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("Список не должен быть пустым!");
        }
        long result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calc(result, Long.valueOf(nums.get(i)));
        }
        return result;
    }

    public static long sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a += b);
    }

    public static long product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a *= b);
    }

}
