package school.faang.task2110;

import school.faang.task2110.calculator.FareCalculator;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        BiFunction<Double, Double, Double> economy = (distance, time) -> distance * 1.1 + time * 1.2;
        BiFunction<Double, Double, Double> comfort = (distance, time) -> distance * 1.4 + time * 1.5;
        BiFunction<Double, Double, Double> business = (distance, time) -> distance * 1.7 + time * 1.8;

        double distance = 10;
        double time = 20;

        double priceForEconomy = FareCalculator.calculateFare(distance, time, economy);
        double priceForComfort = FareCalculator.calculateFare(distance, time, comfort);
        double priceForBusiness = FareCalculator.calculateFare(distance, time, business);

        System.out.println("Price for economy fare: "+priceForEconomy);
        System.out.println("Price for comfort fare: "+priceForComfort);
        System.out.println("Price for business fare: "+priceForBusiness);
    }
}
