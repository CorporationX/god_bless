package BJS2_5211;

import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        try {
            System.out.println(sum(nums));
            System.out.println(product(nums));
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws NoSuchElementException {
        if (nums.isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            result = calculator.operation(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (firstNumber, secondNumber) -> firstNumber * secondNumber);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
}
