package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sumResult = sum(nums);
        int productResult = product(nums);

        System.out.println(sumResult);
        System.out.println(productResult);
    }

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator){

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.apply(result, nums.get(i));
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
