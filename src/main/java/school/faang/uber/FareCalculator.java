package school.faang.uber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BiFunction;

public class FareCalculator {
    private static final Logger logger = LoggerFactory.getLogger(FareCalculator.class);

    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> total) {
        checkDistance(distance);
        checkTime(time);
        return total.apply(distance, time);
    }

    public void checkDistance(double distance) {
        if (!(distance >= 0.0)) {
            throw new IllegalArgumentException("Пройденный путь (distance), должен быть больше 0");
        }
    }

    public void checkTime(double time) {
        if (!(time > 0.0)) {
            throw new IllegalArgumentException("Время поездки должно быть болеше 0.0 секунд");
        }
    }
}