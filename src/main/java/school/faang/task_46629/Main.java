package school.faang.task_46629;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        BiFunction<Double, Double, Double> economy = (distance, time) -> 1.0 * distance + 0.5 * time;
        BiFunction<Double, Double, Double> comfort = (distance, time) -> 1.5 * distance + 0.7 * time;
        BiFunction<Double, Double, Double> comfortPlus = (distance, time) -> 2.0 * distance + 1.25 * time;
        BiFunction<Double, Double, Double> business = (distance, time) -> 2.5 * distance + 2.5 * time;

        FareCalculator fareCalculator = new FareCalculator();

        double distance = 15.0;
        double time = 15.5;

        System.out.println("Стоимость поездки на тарифе эконом на расстояние " + distance + " км составит "
                + fareCalculator.calculateFare(distance, time, economy) + ". Время поездки " + time + " мин");
        System.out.println("Стоимость поездки на тарифе комфорт на расстояние " + distance + " км составит "
                + fareCalculator.calculateFare(distance, time, comfort) + ". Время поездки " + time + " мин");
        System.out.println("Стоимость поездки на тарифе комфорт+ на расстояние " + distance + " км составит "
                + fareCalculator.calculateFare(distance, time, comfortPlus) + ". Время поездки " + time + " мин");
        System.out.println("Стоимость поездки на тарифе Бизнес на расстояние " + distance + " км составит "
                + fareCalculator.calculateFare(distance, time, business) + ". Время поездки " + time + " мин");
    }
}

