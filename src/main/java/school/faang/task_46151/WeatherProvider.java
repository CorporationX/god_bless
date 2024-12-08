package school.faang.task_46151;

import school.faang.task_46151.model.City;
import school.faang.task_46151.model.WeatherData;

public interface WeatherProvider {
    WeatherData fetchWeatherData(City city) throws WeatherServiceException;
}
