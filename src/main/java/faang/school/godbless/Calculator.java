package faang.school.godbless;

import java.util.List;

@FunctionalInterface
public interface Calculator {
    int get(int firstNumber, int secondNumber);

    private static int calculate(List<Integer> nums, Calculator calculator) { // решил сделать метод приватным, потому что обращение к этому методу будет совершаться только в этом интерфейсе
        if (nums.isEmpty()) throw new IllegalArgumentException("list is empty");

        int result = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            System.out.println(nums.get(i));
            result = calculator.get(result, nums.get(i));
        }

        return result;
    }

    static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
}
