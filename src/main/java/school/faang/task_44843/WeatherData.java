package school.faang.task_44843;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Random;

@Getter
@EqualsAndHashCode
@ToString
public class WeatherData {
    private static final double MAX_TEMPERATURE = 55;
    private static final double MIN_TEMPERATURE = -60;
    private static final double MAX_HUMIDITY = 100;
    private static final double MIN_HUMIDITY = 0;

    private String city;
    private double temperature;
    private double humidity;
    private long timestamp;

    public WeatherData(String city) {
        this.city = city;
        this.temperature = generateValue(MIN_TEMPERATURE, MAX_TEMPERATURE);
        this.humidity = generateValue(MIN_HUMIDITY, MAX_HUMIDITY);
        this.timestamp = System.currentTimeMillis();
    }

    private static double generateValue(double minimum, double maximum) {
        Random rn = new Random();
        return rn.nextDouble(maximum - minimum + 1.0) + minimum;
    }
}
