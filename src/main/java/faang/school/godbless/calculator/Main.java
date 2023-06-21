package faang.school.godbless.calculator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Calc calculation = new Calc();

        List<Integer> nums = new ArrayList<>();
        nums.add(4);
        nums.add(5);
        nums.add(8);
        nums.add(9);

        System.out.println("4 + 5 + 8 + 9 = " + Calc.sum(nums));
        System.out.println("4 * 5 * 8 * 9 = " + Calc.product(nums));
    }
}
