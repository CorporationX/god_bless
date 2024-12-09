package school.faang.task_46151;

import school.faang.task_46151.model.City;
import school.faang.task_46151.model.WeatherData;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private final Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(City city) throws WeatherServiceException {

        // To demonstrate, we throw an exception
        if (city == City.MOSCOW) {
            throw new WeatherServiceException("The service is unavailable");
        }

        double temperature = random.nextDouble(-50.0, 50.0);
        double humidity = random.nextDouble(0, 90.0);
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
