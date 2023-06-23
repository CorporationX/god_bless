package faang.school.godbless.sprint3.task6_calculator;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums.isEmpty() || nums==null) {
            throw new IllegalArgumentException("List is null or empty");
        }

        int res = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            res = calculator.calculate(res, nums.get(i));
        }
        return res;
    }

    public static int sum(List<Integer> nums) {
        try {
            return calculate(nums, (a, b) -> a + b);
        } catch (IllegalArgumentException e){
            return 0;
        }
    }

    public static int product(List<Integer> nums) {
        try {
            return calculate(nums, (a, b) -> a * b);
        } catch (IllegalArgumentException e){
            return 0;
        }
    }
}
