package faang.school.godbless.lambda.BJS2_5810;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(100, 200, 300, 400, 500, 1000);

        System.out.println(product(numbers));
        System.out.println(sum(numbers));
    }

    public static long calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("The list cant be empty.");
        }

        long result = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }

        return result;
    }

    public static long product(List<Integer> nums) {
        return calculate(nums, ((a, b) -> a * b));
    }

    public static long sum(List<Integer> nums) {
        return calculate(nums, (Long::sum));
    }
}
