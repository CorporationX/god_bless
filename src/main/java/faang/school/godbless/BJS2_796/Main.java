package faang.school.godbless.BJS2_796;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, Integer.MAX_VALUE);

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
        return nums.stream().reduce(0, (a, b) -> Math.toIntExact(calculator.operate((long)a, (long)b)));
    }
}