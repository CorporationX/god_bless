package faang.school.godbless.calculator;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(4, 8, 2, 3);

        System.out.println(product(integerList));
    }

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть null или пустым");
        }
        int res = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            res = calculator.calculation(res, nums.get(i));
        }
        return res;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (valueFirst, valueSecond) -> valueFirst * valueSecond);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (valueFirst, valueSecond) -> valueFirst + valueSecond);
    }
}
