package school.faang.sprint1.bjs_44850;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private static final Random RANDOM = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = randomValues(15);
        double humidity = randomValues(100);

        return new WeatherData(city, temperature, humidity, System.currentTimeMillis());
    }

    private double randomValues(int bound) {
        return Double.parseDouble(String.format("%.1f", RANDOM.nextDouble(bound)));
    }
}
