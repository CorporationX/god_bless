package faang.school.godbless.calculate;

import java.util.List;

public class Main {
    private final static List<Integer> NUMBERS = List.of(2, 4, 7, 8, 2, 4, 5, 6);

    public static void main(String[] args) {
        System.out.println(product(NUMBERS));
        System.out.println(sum(NUMBERS));
    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("Nums should not be empty!");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
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
