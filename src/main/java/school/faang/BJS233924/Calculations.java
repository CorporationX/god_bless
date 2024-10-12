package school.faang.BJS233924;

import java.util.List;

public class Calculations {
    private static void validate(List<Integer> nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Are you stupid? Where is your f*cking nums?");
        }
    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        validate(nums);
        int result = (calculator.operation(0, 1) == 1) ? 0 : 1;
        for (Integer num : nums) {
            result = calculator.operation(result, num);
        }
        return result;
    }

    public int product(List<Integer> nums) throws IllegalArgumentException {
        validate(nums);
        return calculate(nums, (num1, num2) -> num1 * num2);
    }

    public int sum(List<Integer> nums) throws IllegalArgumentException {
        validate(nums);
        return calculate(nums, Integer::sum);
    }


    public static void main(String[] args) {
        Calculations calculations = new Calculations();
        List<Integer> listOfNums = List.of(1, 2, 3, 4, 5);

        System.out.println(calculations.sum(listOfNums));
        System.out.println(calculations.product(listOfNums));

    }
}
