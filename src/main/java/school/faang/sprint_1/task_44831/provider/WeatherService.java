package school.faang.sprint_1.task_44831.provider;

import school.faang.sprint_1.task_44831.entity.WeatherData;

import java.util.Random;

public class WeatherService implements WeatherProvider {

    @Override
    public WeatherData fetchWeatherData(String city) {
        int maxTemperature = 45;
        int minTemperature = -45;
        double temperature = new Random().nextDouble() * (maxTemperature - minTemperature) + minTemperature;

        int maxHumidity = 100;
        double humidity = new Random().nextDouble(maxHumidity);

        return new WeatherData(city, temperature, humidity, System.currentTimeMillis());
    }
}
