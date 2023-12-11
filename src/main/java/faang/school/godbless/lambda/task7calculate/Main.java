package faang.school.godbless.lambda.task7calculate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        System.out.println(product(nums));
        System.out.println(sum(nums));
        System.out.println(calculate(nums, (a, b) -> b - a));
    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) throw new IllegalArgumentException("Лист не должен быть пустым");

        int res = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            res = calculator.calculate(res, nums.get(i));
        }

        return res;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }

}
