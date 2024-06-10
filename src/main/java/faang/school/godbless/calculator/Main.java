package faang.school.godbless.calculator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 5, 3, 5, 6, 7, 9);
        int sum = Calculation.sum(list);
        int product = Calculation.product(list);
        System.out.println(sum);
        System.out.println(product);
    }
}
