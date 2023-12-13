package faang.school.godbless.calculator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String... args) {
        List<Integer> list = Arrays.asList(1, 5, 8, 3, 2, 7, 8);
        System.out.println(Operations.sum(list));
        System.out.println(Operations.product(list));
    }
}
