package faang.school.godbless.sprint2.BJS2_5392;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(100, 200, 300, 400, 500, 6000);

        System.out.println(product(numbers));
        System.out.println(sum(numbers));
    }

    public static long calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть пустым!");
        }

        long result = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }

        return result;
    }

    public static long product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static long sum(List<Integer> nums) {
        return calculate(nums, Long::sum);
    }
}