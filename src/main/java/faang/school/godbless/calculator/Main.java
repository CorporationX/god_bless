package faang.school.godbless.calculator;

import java.util.Arrays;
import java.util.List;

public class Main<T>{
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(
                1, 2, 3, 4, 5
        );
        System.out.println(product(integers));
        System.out.println(sum(integers));
    }

    public static Integer calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (nums.size() == 1){
            return nums.get(0);
        } else if (nums.isEmpty()) {
            System.err.println("nums is empty");
            throw new IllegalArgumentException();
        } else {
            int result = calculator.calculate(nums.get(0), nums.get(1));
            for (int i = 2; i < nums.size(); i++) {
                result = calculator.calculate(result, nums.get(i));
            }
            return result;
        }
    }

    public static Integer product(List<Integer> nums) {
        return calculate(nums, (v1, v2) -> ((Integer)v1 * (Integer) v2));
    }

    public static Integer sum(List<Integer> nums) {
        return calculate(nums, (v1, v2) -> (Integer) v1 + (Integer) v2);
    }
}
