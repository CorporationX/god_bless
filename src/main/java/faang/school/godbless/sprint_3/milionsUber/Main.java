package faang.school.godbless.sprint_3.milionsUber;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator();

        BiFunction<Double, Double, Double> firstPrice = ((distance, time) -> distance * (time * 1.5));
        BiFunction<Double, Double, Double> secondPrice = ((distance, time) -> distance * 1.4 + time * 1.2);

        double first = fareCalculator.calculateFare(2.0, 2.0, firstPrice);
        double second = fareCalculator.calculateFare(3.5, 0.4, (distance, time) -> distance * 1.5 + time * 0.5);
        double third = fareCalculator.calculateFare(5.5, 1.0, secondPrice);
        System.out.println(first + ", " + second + ", " + third);
    }
}
