package school.faang.sprint1.task_44289;

import java.util.Random;

public class WeatherService implements WeatherProvider {

    private static final int TEMPERATURE_MIN_BOUND_VALUE = -30;
    private static final int TEMPERATURE_MAX_BOUND_VALUE = 65;
    private static final int HUMIDITY_MIN_BOUND_VALUE = 0;
    private static final int HUMIDITY_MAX_BOUND_VALUE = 1000;

    @Override
    public WeatherData fetchWeatherData(String city) {
        Random random = new Random();
        double randomTemp = random.nextDouble(TEMPERATURE_MIN_BOUND_VALUE, TEMPERATURE_MAX_BOUND_VALUE);
        double randomHumidity = random.nextDouble(HUMIDITY_MIN_BOUND_VALUE, HUMIDITY_MAX_BOUND_VALUE);

        return new WeatherData(
                city,
                randomTemp,
                randomHumidity,
                System.currentTimeMillis()
        );
    }
}
