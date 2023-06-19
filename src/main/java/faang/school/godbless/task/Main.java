package faang.school.godbless.task;

import java.util.List;

public class Main {
    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        return nums.stream()
                .reduce(calculator::calc)
                .orElseThrow(IllegalArgumentException::new);
    }

    public static int product(List<Integer> nums) throws IllegalArgumentException {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) throws IllegalArgumentException {
        return calculate(nums, Integer::sum);
    }

    public static void main(String[] args) {
        try {
            int sum = sum(List.of(1, 2, 3, 4));
            System.out.println(sum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            int product = product(List.of(1, 2, 3, 4));
            System.out.println(product);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
