package faang.school.godbless.calculator;

import java.util.List;

import static faang.school.godbless.calculator.Method.calculate;
import static faang.school.godbless.calculator.Method.product;
import static faang.school.godbless.calculator.Method.sum;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(3,5,6);
        int firstMethod = sum(nums);
        int secondMethod = product(nums);
        System.out.println(firstMethod);
        System.out.println(secondMethod);
    }
}
