package school.faang.sprint_2.task_45691;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(sum(List.of(1, 2, 3, 4, 5)));
        System.out.println(product(List.of(1, 2, 3, 4, 5)));
    }

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (nums == null || calculator == null || nums.isEmpty()) {
            throw new IllegalArgumentException();
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
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
