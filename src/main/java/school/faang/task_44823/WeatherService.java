package school.faang.task_44823;

import java.util.Random;

public class WeatherService implements WeatherProvider {

    private Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temp = random.nextDouble(-40, 40);
        double humid = random.nextDouble(20, 80);

       long timestamp = System.currentTimeMillis();
       // long currentTime = System.currentTimeMillis();

        return new WeatherData(city, temp, humid, timestamp);

    }
}
