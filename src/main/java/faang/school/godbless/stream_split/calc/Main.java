package faang.school.godbless.stream_split.calc;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int product(List<Integer> nums) {
        return calculate(nums, (a,b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a,b) -> a + b);
    }

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (!nums.isEmpty()) {
            int sum = nums.get(0);
            for (int i=1; i<nums.size(); i++) {
                sum = calculator.operation(sum, nums.get(i));
            }
            return sum;
        } else throw new IllegalArgumentException();
    }

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();

        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);

        System.out.println(sum(nums));

        System.out.println(product(nums));
    }
}
