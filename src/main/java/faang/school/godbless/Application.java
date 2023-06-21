package faang.school.godbless;

import faang.school.godbless.Hogwarts.SpellCaster;
import faang.school.godbless.UberMillions.FareCalculator;

import java.util.function.BiFunction;

public class Application {
    public static void main(String... args) {

        FareCalculator fareCalculator = new FareCalculator();

// Создание тарифов
        BiFunction<Double, Double, Double> economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        BiFunction<Double, Double, Double> comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
        BiFunction<Double, Double, Double> premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;
        BiFunction<Double, Double, Double> diabloFare = (distance, time) -> 6.66 * distance + 13.0 * time;

// Примеры поездок
        double distance = 10.0;
        double time = 15.0;

        double economyTripCost = fareCalculator.calculateFare(distance, time, economyFare);
        double comfortTripCost = fareCalculator.calculateFare(distance, time, comfortFare);
        double premiumTripCost = fareCalculator.calculateFare(distance, time, premiumFare);
        double diabloTripCost = fareCalculator.calculateFare(distance, time, diabloFare);

        System.out.println("Стоимость поездки на тарифе Economy: " + economyTripCost);
        System.out.println("Стоимость поездки на тарифе Comfort: " + comfortTripCost);
        System.out.println("Стоимость поездки на тарифе Premium: " + premiumTripCost);
        System.out.println("Стоимость поездки по тарифу Сатана: " + diabloTripCost + " и твоя душа");
    }
}
