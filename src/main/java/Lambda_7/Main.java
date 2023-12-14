package Lambda_7;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Calculation calculation = new Calculation();

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(calculation.sum(list));

        System.out.println(calculation.product(list));
    }
}
