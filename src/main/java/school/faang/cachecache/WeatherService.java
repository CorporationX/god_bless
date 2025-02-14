package school.faang.cachecache;

import java.util.Random;

class WeatherService implements WeatherProvider {
    private final Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = -15 + (45 * random.nextDouble());
        double humidity = 20 + (80 * random.nextDouble());
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
