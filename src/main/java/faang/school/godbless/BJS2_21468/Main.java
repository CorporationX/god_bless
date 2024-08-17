package faang.school.godbless.BJS2_21468;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4, 5, 7, 6);
        System.out.println("Result of sum:");
        System.out.println(CalculatorProcessor.sum(nums));
        System.out.println("Result of pow:");
        System.out.println(CalculatorProcessor.product(nums));
    }
}
