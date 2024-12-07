package school.faang.task46529;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        FareCalculator calculator = new FareCalculator();

        BiFunction<Double, Double, Integer> economyFare = (distance, time) -> (int) (1.5 * distance + 0.6 * time);
        BiFunction<Double, Double, Integer> goldFare = (distance, time) -> (int) (5.5 * distance + 3 * time);

        System.out.println("Economy fare: " + calculator.calculateFare(15, 240, economyFare));
        System.out.println("Gold fare: " + calculator.calculateFare(15, 240, goldFare));
    }
}
