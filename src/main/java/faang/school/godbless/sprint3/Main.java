package faang.school.godbless.sprint3;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int result = calculate(List.of(1, 2, 3, 4, 5), Integer::sum);
        System.out.println(result);
    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums == null) {
            throw new IllegalArgumentException();
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.randomOperation(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
}
