package school.faang.bjs2_80124;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> firstNumsList = List.of(1, 2, 3, 3);
        List<Integer> secondNumsList = List.of(1, 3, 9, 3);

        System.out.println("Сумма: " + sum(firstNumsList));
        System.out.println("Произведение: " + product(secondNumsList));
    }

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("List of numbers cannot be null or empty");
        }

        Integer result = nums.get(0);
        for (Integer num : nums) {
            result = calculator.calculate(result, num);
        }
        return result;
    }


    public static Integer sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }

    public static Integer product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

}

