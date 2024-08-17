package faang.school.godbless.javalambda.task7;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();

        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(5);
        nums.add(16);

        System.out.println(sum(nums));
        System.out.println(product(nums));
    }

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }
        Integer result = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            result = calculator.action(result, nums.get(i));
        }
        return result;
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }
}
