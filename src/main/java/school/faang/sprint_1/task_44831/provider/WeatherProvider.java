package school.faang.sprint_1.task_44831.provider;

import school.faang.sprint_1.task_44831.entity.WeatherData;

public interface WeatherProvider {
    WeatherData fetchWeatherData(String city);
}
