package faang.school.godbless.calculator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();

        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);

        System.out.println(sum(nums));
        System.out.println(product(nums));

    }

    public static int calculate(List<Integer> nums, Calculator calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public static Integer sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }

    public static Integer product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }


}
