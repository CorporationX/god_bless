package school.faang.bjs2_87788;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class FareCalculator {

    protected double calculateFare(Double distance, Double time, BiFunction<Double, Double, Double> consumer) {
        return consumer.apply(distance, time);
    }
}
