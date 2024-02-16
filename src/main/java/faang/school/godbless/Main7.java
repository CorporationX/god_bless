package faang.school.godbless;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Calculator {
    long calc(long a, long b);
}

public class Main7 {

    public static long calculate(List<Long> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("empty list or list = null");
        }

        long result = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            result = calculator.calc(result, nums.get(i));
        }
        return result;
    }

    public static long product(List<Long> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static long sum(List<Long> nums) {
        return calculate(nums, (a, b) -> a + b);
    }

    public static void main(String args[]) {
        List<Long> nums = Arrays.asList(2432144314123341233L,4543342234241341423L,8334213412344421341L);

        System.out.println(sum(nums));
        System.out.println(product(nums));
    }
}
