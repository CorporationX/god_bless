package faang.school.functionalinterfacesandlambdas.calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(2, 4, 7, 5, 6);

        try {
            System.out.println(sum(null));
            System.out.println(product(nums));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    private static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть нулевым или пустым");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculator(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (numb1, numb2) -> numb1 * numb2);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (numb1, numb2) -> numb1 + numb2);
    }
}
