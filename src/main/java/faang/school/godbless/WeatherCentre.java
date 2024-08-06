package faang.school.godbless;

import java.util.Random;

public class WeatherCentre {

    public static Random random = new Random();

    public static WeatherData getWeatherData(String city) {
        WeatherData weatherData = new WeatherData();
        weatherData.setCity(city);
        weatherData.setTemperature(random.nextInt(30) + 10);
        weatherData.setHumidity(random.nextInt(60) + 30);
        return weatherData;
    }
}
