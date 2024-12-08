package school.faang.task_46151;

import lombok.extern.slf4j.Slf4j;
import school.faang.task_46151.model.City;
import school.faang.task_46151.model.WeatherData;

@Slf4j
public class Main {
    public static void main(String[] args) {
        WeatherProvider weatherService = new WeatherService();

        fetchWeatherAndPrintNegative(weatherService);
        fetchWeatherAndPrintPositive(weatherService);
    }

    public static void fetchWeatherAndPrintNegative(WeatherProvider weatherService) {
        WeatherData weatherData = ErrorHandler.withErrorHandling(
                () -> weatherService.fetchWeatherData(City.KAZAN),
                (e) -> {
                    log.info(e.getMessage());
                    return null;
                }
        );

        log.info("Weather data: {}", weatherData);
    }

    public static void fetchWeatherAndPrintPositive(WeatherProvider weatherService) {
        WeatherData weatherData = ErrorHandler.withErrorHandling(
                () -> weatherService.fetchWeatherData(City.MOSCOW),
                (e) -> {
                    log.info(e.getMessage());
                    return null;
                }
        );

        log.info("Weather data: {}", weatherData);
    }
}
