package school.faang.sprint1.task_46619;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator();

        BiFunction<Double, Double, Double> economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        BiFunction<Double, Double, Double> comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
        BiFunction<Double, Double, Double> premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;

        double distance = 10.0;
        double time = 15.0;

        double economyType = fareCalculator.calculateFare(distance, time, economyFare);
        double comfortType = fareCalculator.calculateFare(distance, time, comfortFare);
        double premiumType = fareCalculator.calculateFare(distance, time, premiumFare);

        System.out.println("Стоимость поездки на тарифе Economy: " + economyType);
        System.out.println("Стоимость поездки на тарифе Comfort: " + comfortType);
        System.out.println("Стоимость поездки на тарифе Premium: " + premiumType);
    }
}
