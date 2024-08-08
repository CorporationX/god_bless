package faang.school.godbless;

import faang.school.godbless.models.WeatherData;
import lombok.Getter;

import java.util.HashMap;

import static faang.school.godbless.Services.WeatherService.*;

public class Main {

    @Getter
    public static HashMap<String, WeatherData> weatherForecastMap = new HashMap<>();

    public static void main(String[] args) {

        infoWeatherByCity("Moscow");
        infoWeatherByCity("SPB");
        infoWeatherByCity("Moscow");

        printAvailableCitiesInWeatherCache();
        deleteWeatherCacheByCity("Moscow");
        printAvailableCitiesInWeatherCache();

        updateWeatherCacheByCity("SPB");
        printAvailableCitiesInWeatherCache();

        updateWeatherCacheByCity("Moscow");
        printAvailableCitiesInWeatherCache();
    }
}
