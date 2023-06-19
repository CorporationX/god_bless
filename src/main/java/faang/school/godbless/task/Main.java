package faang.school.godbless.task;

import java.util.List;

public class Main {
    public static final String EXCEPTION_MESSAGE = "Cannot calculate empty list";

    public static int calculate(List<Integer> nums, Calculator calculator) {
        return nums.stream()
                .reduce(calculator::calculate)
                .orElseThrow(() -> new IllegalArgumentException(EXCEPTION_MESSAGE));
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }

    public static void main(String[] args) {
        int sum = sum(List.of(1, 2, 3, 4));
        System.out.println(sum);

        int product = product(List.of(1, 2, 3, 4));
        System.out.println(product);
    }
}
