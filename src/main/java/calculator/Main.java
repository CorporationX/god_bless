package calculator;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> nums = List.of(2,2,3);
        product(nums);
        sum(nums);
    }

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) {
        int result = nums.get(0);
        for(int i = 1; i < nums.size(); i++){
            result = calculator.calc(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums){
        int result = calculate(nums, (firstNumber, secondNumber) -> firstNumber * secondNumber);
        System.out.println("Result of product() is " + result);
        return result;
    }

    public static int sum(List<Integer> nums){
        int result = calculate(nums, (firstNumber, secondNumber) -> firstNumber + secondNumber);
        System.out.println("Result of sum() is " + result);
        return result;
    }
}
