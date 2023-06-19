package faang.school.godbless;

import java.util.List;

public class Application {
    public static void main(String... args) {

    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        int res = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            res = calculator.consume(res, nums.get(i));
        }
        return res;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (num1, num2) -> num1 * num2);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
}
