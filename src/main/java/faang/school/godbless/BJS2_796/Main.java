package faang.school.godbless.BJS2_796;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 456, Integer.MAX_VALUE);

        System.out.println(sum(numbers));
        System.out.println(produce(numbers));
    }

    public static long sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> (long) a + b);
    }

    public static long produce(List<Integer> nums) {
        return calculate(nums, (a, b) -> (long) a * b);
    }

    public static long calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("List is null");
        }
        long temp = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            temp = calculator.operate((int) temp, nums.get(i));
        }
        return temp;
    }
}