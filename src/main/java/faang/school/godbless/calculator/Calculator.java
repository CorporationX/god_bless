package faang.school.godbless.calculator;

import java.util.List;

@FunctionalInterface
public interface Calculator<U> {
    U calculate (U firstNum, U secondNum);

    public static int calculate(List<Integer> nums, int identity, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (nums.isEmpty()){
            throw new IllegalArgumentException("No nums in the list");
        }
        int result = nums.stream()
                .reduce(identity,calculator::calculate);
        return result;
    }

    public static int sum(List<Integer> nums) {
        int result = calculate(nums, 0, (a, b) -> a + b);
        return result;
    }

    public static int multiply(List<Integer> nums) {
        return calculate(nums, 1, (a, b) -> a * b);
    }
}
