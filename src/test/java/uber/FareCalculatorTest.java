package uber;

import faang.school.godbless.uber.FareCalculator;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FareCalculatorTest {
  @Test
  public void calculateFareTest() {
    FareCalculator fareCalculator = new FareCalculator();
    // Создание тарифов
    BiFunction<Double, Double, Double> economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
    BiFunction<Double, Double, Double> comfortFare = (distance, time) -> 1.5 * distance + 0.8 * time;
    BiFunction<Double, Double, Double> premiumFare = (distance, time) -> 2.0 * distance + 1.5 * time;

    // Примеры поездок
    double distance = 10.0;
    double time = 15.0;

    double economyTripCost = fareCalculator.calculateFare(distance, time, economyFare);
    double comfortTripCost = fareCalculator.calculateFare(distance, time, comfortFare);
    double premiumTripCost = fareCalculator.calculateFare(distance, time, premiumFare);

    assertEquals(17.5, economyTripCost);
    assertEquals(27.0, comfortTripCost);
    assertEquals(42.5, premiumTripCost);
  }
}
