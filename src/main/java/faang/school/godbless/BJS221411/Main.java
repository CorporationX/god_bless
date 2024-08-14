package faang.school.godbless.BJS221411;

import java.util.List;

public class Main {
    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculator(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        int sumResult = sum(numbers);
        int productResult = product(numbers);

        System.out.println(sumResult);
        System.out.println(productResult);
    }

}

