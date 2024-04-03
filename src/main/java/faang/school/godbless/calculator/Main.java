package faang.school.godbless.calculator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException{
        int result = 0;
        for (int i = 0; i < nums.size() - 1; i++){
            result = i == 0 ? nums.get(i) : result;
            result = calculator.action(result, nums.get(i + 1));
        }
        return result;
    }
    public static int product(List<Integer> nums){
        Calculator calculator = (first, second) -> first * second;
        return calculate(nums, calculator);
    }
    public static int sum(List<Integer> nums){
        Calculator calculator = (first, second) -> first + second;
        return calculate(nums, calculator);
    }
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,3,4,5,6);
        System.out.println(product(nums));
        System.out.println(sum(nums));
    }
}
