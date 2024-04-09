package faang.school.godbless.calculator;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(product(List.of(8L, 9L)));
        System.out.println(sum(List.of(1L, 2L, 3L)));
        System.out.println(product(List.of(1L, 2L, 3L)));
    }

    public static long calculate(List<Long> nums, Calculator<Long> calculator) {
        validateNumbers(nums);
        return nums.stream()
                .reduce(calculator::operation)
                .get();
    }

    public static long product(List<Long> nums) {
        return calculate(nums, ((num1, num2) -> num1 * num2));
    }

    public static long sum(List<Long> nums) {
        return calculate(nums, (Long::sum));
    }

    public static void validateNumbers(List<? extends Number> nums) {
        if (nums.size() < 2) {
            throw new IllegalArgumentException("List size must be greater or equals 2");
        }
    }
}