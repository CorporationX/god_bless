package faang.school.godbless.Calculator;

import lombok.NonNull;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(4, 3, 5, 1);
        System.out.println(sum(nums));
        System.out.println(product(nums));
    }

    public static int calculate(List<Integer> in, Calculator<Integer, Integer, Integer> calculator) {
        int result = in.get(0);
        for (int i = 1; i < in.size(); i++) {
            result = calculator.workCalculator(result, in.get(i));
        }
        return result;
    }

    public static int sum(@NonNull List<Integer> nums) {
        return calculate(nums, (i1, i2) -> i1 + i2);
    }

    public static int product(@NonNull List<Integer> nums) {
        return calculate(nums, (i1, i2) -> i1 * i2);
    }
}
