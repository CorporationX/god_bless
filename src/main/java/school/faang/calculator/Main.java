package school.faang.calculator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(9);

        System.out.println(CalculatorExample.sum(nums));
        System.out.println(CalculatorExample.product(nums));
    }
}