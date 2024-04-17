package faang.school.godbless.sprint2.BJS2_5392;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int productResult = product(numbers);
        int sumResult = sum(numbers);

        System.out.println(productResult);
        System.out.println(sumResult);

    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть пустым!");
        }

        int result = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }

        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
}