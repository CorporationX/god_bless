import java.util.function.BiFunction;

public class Application {
    public static void main(String[] args) {

        FareCalculator fareCalculator = new FareCalculator();

        BiFunction<Double, Double, Double> economyFare = (distance, time) -> (1.0 * distance) * (0.5 * time);
        BiFunction<Double, Double, Double> comfortFare = (distance, time) -> (1.5 * distance) * (1.0 * time);
        BiFunction<Double, Double, Double> businessFare = (distance, time) -> (2.0 * distance) * (1.5 * time);

        double distance = 10;
        double time = 10;

        double economyTripCost = fareCalculator.calculateFare(distance, time, economyFare);
        double comfortTripCost = fareCalculator.calculateFare(distance, time, comfortFare);
        double businessTripCost = fareCalculator.calculateFare(distance, time, businessFare);

        System.out.println("Стоимость поездки на тарифе Economy: " + economyTripCost + " рублей");
        System.out.println("Стоимость поездки на тарифе Comfort: " + comfortTripCost + " рублей");
        System.out.println("Стоимость поездки на тарифе Business: " + businessTripCost + " рублей");
    }
}
