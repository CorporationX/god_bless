package faang.school.godbless;

import faang.school.godbless.Calculator.CalculatorProcess;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String... args) {

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        int numProduct = CalculatorProcess.product(nums);
        int numSum = CalculatorProcess.sum(nums);
        System.out.println(numProduct + " " + numSum);
    }
}
