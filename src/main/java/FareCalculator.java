import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double travelTime, BiFunction<Double, Double, Double> calculator) {
        return calculator.apply(distance, travelTime);
    }
}
