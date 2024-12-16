package faang.school.godbless.sprint_2.task_44862;

import faang.school.godbless.sprint_2.task_44862.weather_cache.FrequentUpdateWeatherCache;
import faang.school.godbless.sprint_2.task_44862.weather_cache.WeatherCacheTemplate;

public class Main {
    public static void main(String[] args) {
        WeatherCacheTemplate weatherData = new FrequentUpdateWeatherCache();

        weatherData.getWeatherData("Moscow", 2_000L);
        weatherData.getWeatherData("Samara", 2_000L);

        System.out.println(weatherData.getWeatherData());
    }
}
