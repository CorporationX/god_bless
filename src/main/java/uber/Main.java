package uber;

import java.util.function.BiFunction;

public class Main {
    private static final FareCalculator fareCalculator = new FareCalculator();
    public static void main(String[] args) {
        BiFunction<Double, Double, Double> coolFare = (distance, time) -> distance * 2.5 + time * 2.0;
        BiFunction<Double, Double, Double> ultraFare = (distance, time) -> distance * 4.0 + time * 2.5;
        BiFunction<Double, Double, Double> gigaChadFare = (distance, time) -> distance * 5.0 + time * 3.0;

        double distance = 1200.10;
        double time = 30;

        double coolTripCost = fareCalculator.calculateFare(distance, time, coolFare);
        double ultraTripCost = fareCalculator.calculateFare(distance, time, ultraFare);
        double gigaChadTripCost = fareCalculator.calculateFare(distance, time, gigaChadFare);

        System.out.println("Стоимость поездки на тарифе Cool: " + coolTripCost);
        System.out.println("Стоимость поездки на тарифе Ultra: " + ultraTripCost);
        System.out.println("Стоимость поездки на тарифе GigaChad: " + gigaChadTripCost);
    }
}
