package school.faang.weather.service;

import school.faang.weather.model.WeatherData;

public interface WeatherProvider {
    WeatherData fetchWeatherData(String city);
}
