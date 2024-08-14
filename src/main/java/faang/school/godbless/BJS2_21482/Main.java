package faang.school.godbless.BJS2_21482;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5);
        System.out.println(CalculatorProcessor.calculate(nums, (a,b) -> a - b));
        System.out.println(CalculatorProcessor.product(nums));
        System.out.println(CalculatorProcessor.sum(nums));
    }
}
