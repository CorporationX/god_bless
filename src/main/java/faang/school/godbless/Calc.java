package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class Calc {

    public static void main(String[] args) {
        Calc calc = new Calc();
        List<Integer> nums = new ArrayList<>();

        nums.add(3);
        nums.add(5);
        nums.add(9);

        System.out.println("3 * 5 * 9 = " + Calc.product(nums));
        System.out.println("3 + 5 + 9 + " + Calc.sum(nums));
    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException{
        Integer result = 1;
        for (Integer num : nums) {
            result = calculator.calculate(num, result);
        }
        return result;
    }

    public static int product(List<Integer> nums){
        Calculator multiply = (first, second) -> first*second;
        return calculate(nums, multiply);
    }

    public static int sum(List<Integer> nums){
        Calculator sum = (Integer::sum);
        return calculate(nums, sum) -1;
    }

}
