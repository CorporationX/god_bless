package school.faang.task_44831.provider;

import school.faang.task_44831.entity.WeatherData;

import java.util.Random;

public class WeatherService implements WeatherProvider {

    @Override
    public WeatherData fetchWeatherData(String city) {

        WeatherData weatherData = new WeatherData(city);

        int maxTemperature = 45;
        int minTemperature = -45;
        weatherData.setTemperature(new Random().nextDouble() * (maxTemperature - minTemperature) + minTemperature);

        int maxHumidity = 100;
        weatherData.setHumidity(new Random().nextDouble(maxHumidity));
        weatherData.setTimestamp(System.currentTimeMillis());

        return weatherData;
    }
}
