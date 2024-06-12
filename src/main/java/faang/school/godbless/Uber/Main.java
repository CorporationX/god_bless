package faang.school.godbless.Uber;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        BiFunction<Double, Double, Integer> price = (t, v) -> (int) (t * 3 + v * 5);
        BiFunction<Double, Double, Integer> luxPrice = (t, v) -> (int) ((t * 3 + v * 5) * 2);
        FareCalculator fareCalculator = new FareCalculator();
        System.out.println(fareCalculator.calculateFare(25.4, 40.7, price));
        System.out.println(fareCalculator.calculateFare(25.4, 40.7, luxPrice));
    }
}
