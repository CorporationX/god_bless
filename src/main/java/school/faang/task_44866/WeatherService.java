package school.faang.task_44866;

import com.github.javafaker.Faker;

public class WeatherService implements WeatherProvider {
    Faker faker = new Faker();

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = faker.number().numberBetween(-10, 40);
        double humidity = faker.number().numberBetween(20, 100);
        long timestamp = System.currentTimeMillis();

        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
