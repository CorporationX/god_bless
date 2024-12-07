package school.faang.task_44842;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class WeatherService implements WeatherProvider {

    private String cityName;
    private WeatherData weatherData;


    public WeatherService(String cityName) {
        this.cityName = cityName;
        fetchWeatherData(cityName);
    }

    @Override
    public WeatherData fetchWeatherData(String city) {

    this.weatherData = new WeatherData(this.cityName, new Random().nextDouble(-4, 34),
            new Random().nextDouble(750, 850), System.currentTimeMillis());
            return weatherData;
    }
}
