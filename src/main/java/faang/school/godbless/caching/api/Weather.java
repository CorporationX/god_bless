package faang.school.godbless.caching.api;

import faang.school.godbless.caching.WeatherData;

public class Weather {
    public WeatherData getWeatherData(String city) {
        return new WeatherData(city, Math.round(Math.random() * 30), Math.round(Math.random() * 100));
    }
}
