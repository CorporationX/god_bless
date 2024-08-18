package faang.school.godbless.task.lambda.user.millionaires;

import java.util.function.BiFunction;

public class FareCalculator {

    public double calculateFare(double distance, double time,
                                BiFunction<Double, Double, Double> biFunction) {
        return biFunction.apply(distance, time);
    }
}
