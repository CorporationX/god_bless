package faang.school.godbless;

import java.util.Arrays;
import java.util.List;

public class Main {
    @FunctionalInterface
    public interface Calculator{
        public int calc(int a, int b);
    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException{
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            result = calculator.calc(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums){
        return calculate(nums, (a, b) -> a*b);
    }

    public static int sum(List<Integer> nums){
        return calculate(nums, (a, b) -> a+b);
    }

    public static void main(String args[]){
        List<Integer> nums = Arrays.asList(2, 4, 8);

        System.out.println(sum(nums));
        System.out.println(product(nums));
    }
}
