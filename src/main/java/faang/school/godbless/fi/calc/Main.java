package faang.school.godbless.fi.calc;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println(product(nums));
        System.out.println(sum(nums));
        System.out.println(calculate(Arrays.asList(1.2, 1.3, 1.4, 1.5), Double::sum));
        System.out.println(calculate(Arrays.asList(1.2, 1.4, 1.4, 1.5), (n1, n2) -> n1 * n2));
    }

    public static <T extends Number> T calculate(List<T> nums, Calculator<T> calculator)
            throws IllegalArgumentException {

        if (nums.isEmpty()) {
            throw new IllegalArgumentException("List of numbers is empty!");
        } else {
            var result = nums.get(0);

            for (int i = 1; i < nums.size(); i++) {
                result = calculator.calculate(result, nums.get(i));
            }

            return result;
        }
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (n1, n2) -> n1 * n2);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
}
