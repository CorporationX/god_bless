package school.faang.bjs244827.service;

import school.faang.bjs244827.model.WeatherData;

public interface WeatherProvider {
    WeatherData fetchWeatherData(String city);
}