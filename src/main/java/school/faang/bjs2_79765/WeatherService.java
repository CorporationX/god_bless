package school.faang.bjs2_79765;

import java.util.Random;

public class WeatherService implements WeatherProvider {

    @Override
    public WeatherData fetchWeatherData(String city) {
        Random random = new Random();

        int minus =  random.nextDouble() > 0.5 ? 1 : -1;
        double temperature = minus * random.nextDouble() * 25 + 20;
        double humidity = random.nextDouble() * 100;

        return new WeatherData(city, temperature, humidity, System.currentTimeMillis());
    }

}
