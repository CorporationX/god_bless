package faang.school.godbless.Sprint3.Task_4_Uber;

import java.util.function.BiFunction;

public class FareCalculator {
    public static double  calculateFare (double distance, double time, BiFunction <Double, Double, Double> fareFunction) {
        return fareFunction.apply(distance, time);
    }

    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator();

// Создание тарифов
        BiFunction<Double, Double, Double> economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        BiFunction<Double, Double, Double> comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
        BiFunction<Double, Double, Double> premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;

// Примеры поездок
        System.out.println("Стоимость поездки на тарифе Economy: " + fareCalculator.calculateFare(20, 30, economyFare));
        System.out.println("Стоимость поездки на тарифе Comfort: " + fareCalculator.calculateFare(20, 30, comfortFare));
        System.out.println("Стоимость поездки на тарифе Premium: " + fareCalculator.calculateFare(20, 30, premiumFare));
    }
}
