package faang.school.godbless.BJS2_21470;

import java.util.List;
import java.util.function.ToIntFunction;

public class CalculatorService {

    public static int product(List<Integer> numbers) {
        return calculate(numbers, (nums) ->
                nums.stream().reduce(1, (x, y) -> x * y));
    }

    public static int sum(List<Integer> numbers) {
        return calculate(numbers, (nums) ->
                nums.stream().reduce(0, Integer::sum));
    }

    public static int calculate(List<Integer> nums, ToIntFunction<List<Integer>> calculator) throws IllegalArgumentException {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        return calculator.applyAsInt(nums);
    }
}
