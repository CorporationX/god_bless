package school.faang.Calculator;

import java.util.List;
import java.util.Optional;

public class Service {

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        Optional<Integer> result = nums.stream().reduce(calculator::calculate);
        return result.orElse(0);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }
}
