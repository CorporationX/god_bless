package faang.school.godbless.calculator;

import java.util.List;

public class Main {
    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return calculator.calculate(nums);
    }

    public static int product(List<Integer> nums) {
        return nums.stream().reduce(1, (acc, x) -> acc * x);
    }

    public static int sum(List<Integer> nums) {
        return nums.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        System.out.println(product(List.of(1, 2, 3, 4)));
        System.out.println(sum(List.of(1, 2, 3, 4)));
    }
}
