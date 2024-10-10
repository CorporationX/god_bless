package bjs2_29014;

import java.util.Random;

public class WeatherForecast {
    public static Random random = new Random();

    public static WeatherData searchCityWeatherData(String city) {
        double temperature = Math.round(random.nextDouble(-30.0, 45.0));
        int humidity = random.nextInt(0, 100);

        return new WeatherData(city, temperature, humidity);
    }

    public static WeatherData searchCityWeatherData(String city, double temperature) {
        int humidity = random.nextInt(0, 100);
        return new WeatherData(city, temperature, humidity);
    }

    public static WeatherData searchCityTemperature(String city, int humidity) {
        double temperature = random.nextDouble(0, 100);
        return new WeatherData(city, temperature, humidity);
    }
}
