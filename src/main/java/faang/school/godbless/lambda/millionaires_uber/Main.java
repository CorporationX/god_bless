package faang.school.godbless.lambda.millionaires_uber;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {

        BiFunction<Double, Double, Double> econom = (distance, time) -> distance * 1.0 + time * 1.0;
        BiFunction<Double, Double, Double> comfort = (distance, time) -> distance * 1.5 + time * 1.3;
        BiFunction<Double, Double, Double> bussines = (distance, time) -> distance * 2.0 + time * 2.0;

        int distance = 10;
        int time = 30;

        System.out.println(FareCalculator.calculateFare(distance, time, econom));
        System.out.println(FareCalculator.calculateFare(distance, time, comfort));
        System.out.println(FareCalculator.calculateFare(distance, time, bussines));

    }
}
