package faang.school.godbless.lamdbastreamapi.uber;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Main {

    public static final Map<String, BiFunction<Double, Double, Double>> TARIF_CALCULATION = new HashMap<>();
    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator();

        TARIF_CALCULATION.put("economy", (distance, time) -> 1.0 * distance + 0.5 * time);
        TARIF_CALCULATION.put("comfort", (distance, time) -> 1.5 * distance + 0.8 * time);
        TARIF_CALCULATION.put("premium", (distance, time) -> 2.0 * distance + 1.5 * time);


        double distance = 10.0;
        double time = 15.0;

        double economyTripCost = fareCalculator.calculateFare(distance, time, TARIF_CALCULATION.get("economy"));
        double comfortTripCost = fareCalculator.calculateFare(distance, time, TARIF_CALCULATION.get("comfort"));
        double premiumTripCost = fareCalculator.calculateFare(distance, time, TARIF_CALCULATION.get("premium"));

        System.out.println("Стоимость поездки на тарифе Economy: " + economyTripCost);
        System.out.println("Стоимость поездки на тарифе Comfort: " + comfortTripCost);
        System.out.println("Стоимость поездки на тарифе Premium: " + premiumTripCost);
    }
}
