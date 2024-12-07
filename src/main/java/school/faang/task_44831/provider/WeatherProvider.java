package school.faang.task_44831.provider;

import school.faang.task_44831.entity.WeatherData;

public interface WeatherProvider {
    WeatherData fetchWeatherData(String city);
}
