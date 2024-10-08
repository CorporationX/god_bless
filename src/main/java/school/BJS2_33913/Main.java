package school.BJS2_33913;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        System.out.println(sum(nums));
        System.out.println(product(nums));
    }


    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        int result = calculator.method(nums.get(0), nums.get(1));
        for (int i = 2; i < nums.size(); i++) {
            result = calculator.method(result, nums.get(i));
        }
        return result;
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (x, y) -> x + y);
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (x, y) -> x * y);
    }


}