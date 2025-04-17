package school.faang.bjs2_70443;

import lombok.extern.slf4j.Slf4j;

import java.util.function.BiFunction;

@Slf4j
public class Main {
    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator();

        BiFunction<Double, Double, Double> economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        BiFunction<Double, Double, Double> comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
        BiFunction<Double, Double, Double> premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;

        double distance = 10.0;
        double time = 15.0;

        double economyTripCost = fareCalculator.calculateFare(distance, time, economyFare);
        double comfortTripCost = fareCalculator.calculateFare(distance, time, comfortFare);
        double premiumTripCost = fareCalculator.calculateFare(distance, time, premiumFare);

        log.info("Стоимость поездки на тарифе Economy: {}", economyTripCost);
        log.info("Стоимость поездки на тарифе Comfort: {}", comfortTripCost);
        log.info("Стоимость поездки на тарифе Premium: {}", premiumTripCost);
    }
}