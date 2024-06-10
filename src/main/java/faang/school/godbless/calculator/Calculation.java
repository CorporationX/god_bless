package faang.school.godbless.calculator;

import java.util.List;

public class Calculation {
    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException{
        if(nums == null || calculator == null){
            throw new IllegalArgumentException("Arguments and function cannot be null");
        }
        if(nums.isEmpty()){
            throw new IllegalArgumentException("Cannot make any operations with empty list");
        }
        int result = nums.get(0);
        for(int i = 1; i < nums.size(); i++){
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public static int sum(List<Integer> nums){
        return calculate(nums, Integer::sum);
    }

    public static int product(List<Integer> nums){
        return calculate(nums, (a, b) -> a * b);
    }

}
