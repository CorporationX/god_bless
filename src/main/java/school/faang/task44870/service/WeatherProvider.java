package school.faang.task44870.service;

import school.faang.task44870.model.WeatherData;

public interface WeatherProvider {
    WeatherData fetchWeatherData(String city);
}
