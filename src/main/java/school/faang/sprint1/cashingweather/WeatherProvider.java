package school.faang.sprint1.cashingweather;

/**
 * Defines a contract for fetching weather data from a source
 */
public interface WeatherProvider {

    /**
     * Fetches latest weather data for a given city
     *
     * @param city city name
     * @return weather data
     */
    WeatherData fetchWeatherData(String city);
}
