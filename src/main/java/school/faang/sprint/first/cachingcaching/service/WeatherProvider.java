package school.faang.sprint.first.cachingcaching.service;

import school.faang.sprint.first.cachingcaching.model.WeatherData;

public interface WeatherProvider {
    WeatherData fetchWeatherData(String city);
}
