package school.faang.sprint1_2.bjs2_80124;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> firstNumsList = List.of(1, 2, 3, 3);
        List<Integer> secondNumsList = List.of(1, 3, 9, 3);

        System.out.printf("Сумма: %s, ожидаемое значение: %s\n", sum(firstNumsList), 9);
        System.out.printf("Произведение: %s, ожидаемое значение: %s\n", product(secondNumsList), 81);
    }

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("List of numbers cannot be null or empty");
        }

        Integer result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
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

