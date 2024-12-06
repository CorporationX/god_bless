package school.faang.sprint_1.task_44835.service;

import school.faang.sprint_1.task_44835.dto.WeatherData;

public interface WeatherProvider {
    WeatherData fetchWeatherData(String city);
}
