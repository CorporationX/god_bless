package school.faang.calculate;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(Calculate.calculate(List.of(1, 3, 5), Integer::sum));
        System.out.println(Calculate.sum(List.of(4, 8, 13, -1)));
        System.out.println(Calculate.product(List.of(3, 5, 10)));
        System.out.println(Calculate.calculate(List.of(20, 40), (a, b) -> a - b));
        System.out.println(Calculate.calculate(List.of(), (a, b) -> a * b));
    }
}
