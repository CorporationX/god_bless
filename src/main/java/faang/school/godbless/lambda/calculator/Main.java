package faang.school.godbless.lambda.calculator;

import java.util.List;

public class Main {
    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException{
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }
        int result = nums.get(0);
        for (int i = 0; i < nums.size()-1; i++) {
            result = calculator.calculate(result, nums.get(i+1));
        }
        return result;
    }

    public static int product(List<Integer> nums){
        return calculate(nums, (firstNum, secondNum) -> firstNum + secondNum);
    }

    public static int sum(List<Integer> nums){
        return calculate(nums, (firstNum, secondNum) -> firstNum * secondNum);
    }

    public static void main(String[] args) {
        System.out.println(product(List.of(1, 3, 5, 7, 9)));
        System.out.println(sum(List.of(1, 2,3,4,5)));
    }
}
