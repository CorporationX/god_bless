package faang.school.godbless.javahashmap.task3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, WeatherData> weathersServer = new HashMap<>();
    private static Map<String, WeatherData> weathersCache = new HashMap<>();

    public static void main(String... args) {
        initWeathersServer();

        getWeather("City3"); //кэш работает
        getWeather("City3");
        getWeather("City8");


    }
    public static void initWeathersServer() {
        WeatherData data1 = new WeatherData("City1", 25, 60);
        WeatherData data2 = new WeatherData("City2", 30, 70);
        WeatherData data3 = new WeatherData("City3", 22, 55);
        WeatherData data4 = new WeatherData("City4", 28, 75);
        WeatherData data5 = new WeatherData("City5", 18, 50);
        WeatherData data6 = new WeatherData("City6", 32, 80);

        weathersServer.put(data1.getCity(), data1);
        weathersServer.put(data2.getCity(), data2);
        weathersServer.put(data3.getCity(), data3);
        weathersServer.put(data4.getCity(), data4);
        weathersServer.put(data5.getCity(), data5);
        weathersServer.put(data6.getCity(), data6);

        System.out.println("Погода добавлена на сервер\n");
    }
    public static void saveWeathersCache(String city) {
        if (!weathersServer.containsKey(city)) {
            weathersServer.put(city, new WeatherData(city, city.length()*2, city.length()*4));
            weathersCache.put(city, new WeatherData(city, city.length()*2, city.length()*4));
        } else {
            weathersCache.put(city, weathersServer.get(city));
        }

        System.out.println("Погода сохранена в кэш\n");
    }
    public static void getWeather(String city) {
        if (!weathersCache.containsKey(city)) {
            saveWeathersCache(city);
        }

        int temperature = weathersCache.get(city).getTemperature();
        int humidity= weathersCache.get(city).getHumidity();

        System.out.println("[ Город: " + city + "  Температура: " + temperature + "  Влажность: " + humidity + " ]\n");
    }

}
