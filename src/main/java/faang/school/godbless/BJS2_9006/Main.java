package faang.school.godbless.BJS2_9006;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2 ,3 ,5 ,6);

        System.out.println("sum: " + sum(list));
        System.out.println("product: " + product(list));
    }

    private static int calculate(List<Integer> nums, Calculator calculator) {
        int result = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculation(result, nums.get(i));
        }

        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (num1, num2) -> num1 * num2);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (Integer::sum));
    }
}
