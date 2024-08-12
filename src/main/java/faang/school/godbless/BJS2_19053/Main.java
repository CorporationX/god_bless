package faang.school.godbless.BJS2_19053;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final City MOSCOW = new City("Москва");
    public static final City PERMIAN = new City("Пермь");
    public static final City UFA = new City("Уфа");
    public static final City SAMARA = new City("Самара");
    public static final City NOVOSIBIRSK = new City("Новосибирск");
    public static final City EKATERINBURG = new City("Екатеринбург");

    public static final Map<String, WeatherData> WEATHER_DATA_CACHE = new HashMap<>() {{
        put(MOSCOW.getName(), new WeatherData(MOSCOW, 18.8, 59.3));
        put(PERMIAN.getName(), new WeatherData(PERMIAN, 15, 69));
        put(UFA.getName(), new WeatherData(UFA, 16, 94));
        put(SAMARA.getName(), new WeatherData(SAMARA, 20.3, 80));
        put(NOVOSIBIRSK.getName(), new WeatherData(NOVOSIBIRSK, 12.1, 81));
        put(EKATERINBURG.getName(), new WeatherData(EKATERINBURG, 14, 81));
    }};

    public static WeatherData getWeatherInformationByCityName(String cityName) {
        return WEATHER_DATA_CACHE.computeIfAbsent(cityName, (key) -> ExternalServiceWithWeatherData.getWeatherData(key));
    }

    public static void updateWeatherDataForACity(City city, WeatherData weatherData) {
        WEATHER_DATA_CACHE.replace(city.getName(), weatherData);
    }

    public static void deleteWeatherDataForACity(City city) {
        WEATHER_DATA_CACHE.remove(city.getName());
    }

    public static void printAllCitiesFromCache() {
        for (WeatherData weatherData : WEATHER_DATA_CACHE.values()) {
            System.out.println(weatherData.getCity());
        }
    }

    public static void main(String[] args) {
        printAllCitiesFromCache();
    }
}
