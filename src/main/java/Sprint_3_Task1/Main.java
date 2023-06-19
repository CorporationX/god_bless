package Sprint_3_Task1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(4, 6, 2, 4, 1);
        System.out.println(sum(list));
        System.out.println(product(list));

    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }
        int result = nums.get(0);
        for (int i = 0; i < nums.size() - 1; i++) {
            result = calculator.calculate(result, nums.get(i + 1));
        }

        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }
}
