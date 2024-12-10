package school.faang.sprint1.task_44289;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(String city) {
        Random random = new Random();
        double randomTemp = random.nextDouble(-30, 65);
        double randomHumidity = random.nextDouble(0, 1000);

        return new WeatherData(
                city,
                randomTemp,
                randomHumidity,
                System.currentTimeMillis()
        );
    }
}
