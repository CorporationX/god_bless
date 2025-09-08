package school.faang.module1.weather;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

public class WeatherService implements WeatherProvider {

    private static final Double MIN_VALUE = -30.0;
    private static final Double MAX_VALUE = 50.0;
    private static final int DEFAULT_SCALE = 1;

    @Override
    public WeatherData fetchWeatherData(String city) {
        return new WeatherData(city, rndTemperature(), rndHumidity(), System.currentTimeMillis());
    }

    private double rndTemperature() {
        double value = ThreadLocalRandom.current().nextDouble(MIN_VALUE, MAX_VALUE);
        return round(value);
    }

    private double rndHumidity() {
        double value = ThreadLocalRandom.current().nextDouble(0.0, 100.0);
        return round(value);
    }

    private double round(double value) {
        return BigDecimal.valueOf(value)
                .setScale(DEFAULT_SCALE, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
