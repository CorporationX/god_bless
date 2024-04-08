package calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(10,20,30,40,50);

        System.out.println(product(nums));
        System.out.println(sum(nums));
    }

    public static int calculate(List<Integer> nums, Calculator calculator) {
        if (nums.size() < 2) {
            throw new IllegalArgumentException("The list must have more than 2 elements");
        }
        int res = nums.get(0);
        for(int i = 1; i < nums.size(); i++) {
            res = calculator.calculate(res, nums.get(i));
        }
        return res;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, ((num1, num2) -> num1 * num2));
    }

    public static int sum(List<Integer> nums) {

        return calculate(nums, (Integer::sum));
    }
}
