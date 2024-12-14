package faang.school.godbless.calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer productRes = product(List.of(1,2,3,4,5));
        System.out.println(productRes);
    }
    public static Integer calculate(List<Integer> nums,Calculator<Integer,Integer,Integer> calculator) throws IllegalArgumentException{
        Integer res = nums.get(0);
        for (int i = 0; i < nums.size(); i++) {
            res = calculator.act(res,nums.get(i));
        }
        return res;
    }
    public static int product(List<Integer> nums){
        Calculator<Integer,Integer,Integer> calculator = (a,b)->a * b;
        return calculate(nums, calculator);
    }
    public static int sum(List<Integer> nums){
        Calculator<Integer,Integer,Integer> calculator = Integer::sum;
        return calculate(nums, calculator);
    }
}
