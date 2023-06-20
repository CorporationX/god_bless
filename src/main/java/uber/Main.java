package uber;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator();

        BiFunction<Double, Double, Double> economy = (distance, time) -> 1. * distance + 1. * time;
        BiFunction<Double, Double, Double> comfort = (distance, time) -> 1.5 * distance + 1.2 * time;

        double distance = 5.2;
        double time = 16.;

        double priceEconomy = fareCalculator.calculateFare(distance, time, economy);
        double priceComfort = fareCalculator.calculateFare(distance, time, comfort);

        System.out.println("Поездка на экономе будет стоить: " + priceEconomy);
        System.out.println("Поездка на комфорте будет стоить: " + priceComfort);
    }

}
