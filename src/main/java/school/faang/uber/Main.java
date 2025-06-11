package school.faang.uber;

import java.util.function.DoubleBinaryOperator;

/**
 * @author Danil Pudovkin
 * @since 11.06.2025
 */
public class Main {

    public static void main(String[] args) {
        var fareCalculator = new FareCalculator();

        var economyFare = (DoubleBinaryOperator) (distance, time) -> distance + 0.5 * time;
        var comfortFare = (DoubleBinaryOperator) (distance, time) -> 1.5 * distance + 0.8 * time;
        var premiumFare = (DoubleBinaryOperator) (distance, time) -> 2.0 * distance + 1.5 * time;

        double distance = 10;
        double time = 15;

        var economyTripCost = fareCalculator.calculateFare(distance, time, economyFare);
        var comfortTripCost = fareCalculator.calculateFare(distance, time, comfortFare);
        var premiumTripCost = fareCalculator.calculateFare(distance, time, premiumFare);

        System.out.println("Стоимость поездки на тарифе Economy: " + economyTripCost);
        System.out.println("Стоимость поездки на тарифе Comfort: " + comfortTripCost);
        System.out.println("Стоимость поездки на тарифе Premium: " + premiumTripCost);
    }
}
