package school.faang.sprint_1.caching_caching;

import lombok.Getter;
import lombok.Setter;

import java.security.SecureRandom;

@Setter
@Getter
public class WeatherService implements WeatherProvider {

    private static final SecureRandom RANDOMIZER = new SecureRandom();
    private static final int DEFAULT_ORDER = 1;

    private int order;

    public WeatherService() {
        this.order = DEFAULT_ORDER;
    }

    @Override
    public WeatherData fetchWeatherData(String city) {
        return new WeatherData(
                city,
                roundTo(RANDOMIZER.nextDouble(-30, 31), getOrder()),
                roundTo(RANDOMIZER.nextDouble(0, 101), getOrder()),
                System.currentTimeMillis()
        );
    }

    private Double roundTo(Double value, int order) {
        double orderCreator = Math.pow(10, order);
        return Math.round(value * orderCreator) / orderCreator;
    }
}
