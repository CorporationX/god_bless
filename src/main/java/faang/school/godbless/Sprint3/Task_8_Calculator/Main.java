package faang.school.godbless.Sprint3.Task_8_Calculator;

import java.util.List;

public class Main {
    public static int calculate (List<Integer> nums, Calculator calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть пустым");
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate (result, nums.get(i));
        }
        return result;
    }
    public static int product (List<Integer> nums) {
        return calculate(nums, (value1, value2) -> value1 * value2);
    }
    public static int sum (List<Integer> nums) {
        return calculate(nums, (value1, value2) -> value1 + value2);
    }
    public static void main(String[] args) {
        List<Integer> integerList = List.of(6, 5, 3, 8, 2, 1);
        System.out.println(sum(integerList));
        System.out.println(product(integerList));
    }
}
