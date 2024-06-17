package faang.school.godbless.BJS2_8986;

import java.util.List;

public class CalcOperations {
    private void calculate(List<Integer> nums, Calculator<Integer, Integer> calculator) throws IllegalArgumentException {
        System.out.println(nums.stream().reduce(calculator::evaluate).get());
    }

    public void product(List<Integer> nums) {
        Calculator<Integer, Integer> multiplier = (x, y) -> x * y;
        calculate(nums, multiplier);
    }

    public void sum(List<Integer> nums) {
        Calculator<Integer, Integer> multiplier = Integer::sum;
        calculate(nums, multiplier);
    }
}
