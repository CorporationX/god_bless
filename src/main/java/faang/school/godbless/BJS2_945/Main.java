package faang.school.godbless.BJS2_945;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> listOfNumbers = List.of(1, 2, 3, 4, 5);

        System.out.println(sum(listOfNumbers));
        System.out.println(product(listOfNumbers));
    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if(nums.isEmpty()) {
            throw new IllegalArgumentException("List is empty.");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            result = calculator.calculator(nums.get(i), result);
        }
        return result;
    }
    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a*b);
    }
    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a+b);
    }
}
