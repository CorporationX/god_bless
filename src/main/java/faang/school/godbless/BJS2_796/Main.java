package faang.school.godbless.BJS2_796;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        System.out.println(sum(numbers));
        System.out.println(produce(numbers));
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }

    public static int produce(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums == null) {
            throw new IllegalArgumentException("List is null");
        }
        return nums.stream().reduce((a, b) -> Math.toIntExact(calculator.operate(a, b)))
                .orElse(0);
    }
}