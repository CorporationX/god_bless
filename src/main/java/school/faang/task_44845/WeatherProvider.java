package school.faang.task_44845;

import school.faang.task_44845.entity.WeatherData;

public interface WeatherProvider {
    WeatherData fetchWeatherData(String city);
}
