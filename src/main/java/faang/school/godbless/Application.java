package faang.school.godbless;

import faang.school.godbless.calculator.Calculator;

import java.util.List;

public class Application {
    public static void main(String... args) {
    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        return nums.stream().reduce(nums.get(0), calculator::calculate);
    }
}
