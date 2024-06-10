package faang.school.godbless.kalculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> listNumbers = List.of(1, 3, 5);
        System.out.println(product(listNumbers));
        System.out.println(sum(listNumbers));
    }

    public static int calculate(List<Integer> nums, Calculator<Integer, Integer, Integer> calculator) {
        int buffer = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            buffer = calculator.interfaceCalculate(buffer, nums.get(i));
        }
        return buffer;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (s, h) -> s * h);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (s, h) -> s + h);
    }
}