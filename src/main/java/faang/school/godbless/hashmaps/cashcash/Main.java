package faang.school.godbless.hashmaps.cashcash;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    private static final Map<String, WeatherData> CASH_WEATHER = new HashMap<>();
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        System.out.println(getWeatherInfo("Москва"));
        System.out.println(getWeatherInfo("Сочи"));
        System.out.println();

        showCityCashInfo();
        System.out.println();

        System.out.println("Повторный запрос к тем же городам");
        System.out.println(getWeatherInfo("Москва"));
        System.out.println(getWeatherInfo("Сочи"));
        System.out.println();

        removeCityCash("Москва");
        showCityCashInfo();
        System.out.println();

        updateCash("Сочи", 30, 2);
        showCityCashInfo();

    }

    public static WeatherData getWeatherInfo(String city) {
        if(CASH_WEATHER.containsKey(city)) {
            return CASH_WEATHER.get(city);
        }
        WeatherData weatherData = getWeather(city);
        updateCash(city, weatherData.getTemperature(), weatherData.getHumidity());
        return weatherData;

    }

    public static WeatherData getWeather(String city) {
        return new WeatherData(city, RANDOM.nextInt(15, 30), RANDOM.nextInt(0, 20));
    }

    public static void updateCash(String city, int temperature, int humidity) {
        CASH_WEATHER.put(city, new WeatherData(city, temperature, humidity));
    }

    public static void removeCityCash(String city) {
        CASH_WEATHER.remove(city);
    }

    public static void showCityCashInfo() {
        System.out.println("Информации о погоде из кэша");
        for (Map.Entry<String, WeatherData> weatherEntry : CASH_WEATHER.entrySet()) {
            System.out.println(weatherEntry.getValue());
        }
    }


}
