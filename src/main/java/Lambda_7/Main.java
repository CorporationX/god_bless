package Lambda_7;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Calculat calculat = new Calculat();

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(calculat.sum(list));

        System.out.println(calculat.product(list));
    }
}
