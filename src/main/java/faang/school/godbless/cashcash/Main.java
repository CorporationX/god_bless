package faang.school.godbless.cashcash;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    private static Map<String, WeatherData> cashWeather = new HashMap<>();

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
        if(cashWeather.containsKey(city)) {
            return cashWeather.get(city);
        } else {
            WeatherData weatherData = getWeather(city);
            updateCash(city, weatherData.getTemperature(), weatherData.getHumidity());
            return weatherData;
        }
    }

    public static WeatherData getWeather(String city) {
        Random random = new Random();
        return new WeatherData(city, random.nextInt(15, 30), random.nextInt(0, 20));
    }

    public static void updateCash(String city, int temperature, int humidity) {
        cashWeather.put(city, new WeatherData(city, temperature, humidity));
    }

    public static void removeCityCash(String city) {
        cashWeather.remove(city);
    }

    public static void showCityCashInfo() {
        System.out.println("Информации о погоде из кэша");
        for (Map.Entry<String, WeatherData> weatherEntry : cashWeather.entrySet()) {
            System.out.println(weatherEntry.getValue());
        }
    }


}
