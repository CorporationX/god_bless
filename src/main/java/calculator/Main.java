package calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> testList = List.of (1, 3, 2, 3, 6, 3, 2, 6, 5);
        System.out.println(Calculate.product(testList));
        System.out.println(Calculate.sum(testList));
    }

}
