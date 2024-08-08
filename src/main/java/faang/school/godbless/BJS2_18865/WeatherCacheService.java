package faang.school.godbless.BJS2_18865;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

public class WeatherCacheService {
    @Getter @Setter
    private HashMap<String, WeatherData> cachedData = new HashMap<>();

    protected void storeData(final String city, final WeatherData weatherData) {
        cachedData.put(city, weatherData);
    }

    protected boolean containsCity(final String city) {
        return cachedData.containsKey(city);
    }

    protected WeatherData weatherFor(final String city) {
        return cachedData.get(city);
    }

    protected void editData(final String city, final WeatherData weatherData) {
        cachedData.put(city, weatherData);
    }

    protected void removeData(final String city) {
        cachedData.remove(city);
    }

    public void printAllCache() {
        for (final WeatherData weatherData : cachedData.values()) {
            System.out.println(weatherData);
        }
    }


}
