package faang.school.godbless.UberMillionaires;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator();

        BiFunction<Integer, Integer, Double> economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        BiFunction<Integer, Integer, Double> comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
        BiFunction<Integer, Integer, Double> premiumFare = (distance, time) -> 2.0 * distance + 1.0 * time;

        int distance = 10;
        int time = 15;

        double economyTariff = fareCalculator.calculateFare(distance, time, economyFare);
        double comfortTariff = fareCalculator.calculateFare(distance, time, comfortFare);
        double premiumTariff = fareCalculator.calculateFare(distance, time, premiumFare);

        System.out.println("Стоимость поездки на тарифе Economy: " + economyTariff);
        System.out.println("Стоимость поездки на тарифе Comfort: " + comfortTariff);
        System.out.println("Стоимость поездки на тарифе Premium: " + premiumTariff);
    }
}
