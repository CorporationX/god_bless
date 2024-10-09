package school.faang.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Integer> nums = Arrays.asList(1, 2, 3, 4);
            System.out.println("Sum is " + sum(nums));
            System.out.println("Product is " + product(nums));

            List<Integer> emptyList = new ArrayList<>();
            sum(emptyList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int calculate(List<Integer> nums, Calculator<Integer, Integer, Integer> calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("Empty list provided");
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
        return calculate(nums, (x, y) -> x * y);
    }
}
