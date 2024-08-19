package faang.school.godbless.SecondSprint.BJS2_21512;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(1);

        System.out.println(prod(list));
    }

    public static int calculate(List<Integer> nums, Calculator<Integer, Integer> calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            result = calculator.calc(result, nums.get(i));
        }
        return result;
    }

    public static int sum(List<Integer> nums) {
        int calculate = calculate(nums, (a, b) -> a + b);
        return calculate;
    }

    public static int prod(List<Integer> nums) {
        int calculate = calculate(nums, (a, b) -> a * b);
        return calculate;
    }
}
