package dima.evseenko.weather;

import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockedWeatherRepository implements WeatherRepository {
    private final Map<String, WeatherData> weatherDataList = mock(Map.class);

    @Override
    public WeatherData getWeather(String city) {
        when(weatherDataList.get("Санкт-Петербург")).thenReturn(new WeatherData("Санкт-Петербург", 9, 91));
        when(weatherDataList.get("Москва")).thenReturn(new WeatherData("Москва", 12, 79));
        when(weatherDataList.get("Екатеринбург")).thenReturn(new WeatherData("Екатеринбург", 16, 25));
        when(weatherDataList.get("Ростов-на-Дону")).thenReturn(new WeatherData("Ростов-на-Дону", 24, 25));
        when(weatherDataList.get("Краснодар")).thenReturn(new WeatherData("Краснодар", 25, 34));
        when(weatherDataList.get("Воронеж")).thenReturn(new WeatherData("Воронеж", 22, 23));

        return weatherDataList.get(city);
    }
}
