package faang.school.godbless.calculator;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(null, 1, 2);

        System.out.println(product(numberList));

        System.out.println(sum(numberList));
    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        int result = 0;
        if (nums.isEmpty() || nums.contains(null)) {
            System.out.println("Некорректные входящие данные!");
        } else {
            result = nums.get(0);
            for (int i = 1; i < nums.size(); i++) {
                result = calculator.apply(result, nums.get(i));
            }
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
