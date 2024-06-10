package faang.school.godbless.bjs2_9977;

import java.util.function.BiFunction;

public class FareCalculator {

  public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> biFunction) {
    return biFunction.apply(distance, time);
  }

}
