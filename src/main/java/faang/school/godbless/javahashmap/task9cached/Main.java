package faang.school.godbless.javahashmap.task9cached;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<String, WeatherData> weathersServer = new HashMap<>();
    private static final Map<String, WeatherData> weathersCache = new HashMap<>();

    public static void main(String... args) {
        initWeathersServer();

        getWeather("City5"); //кэш работает
        getWeather("City5");
        getWeather("rthrht");

        updateInfoCathe("fggdffdg");
        updateInfoCathe("City5");

        removeInfoCathe("aeffea");
        removeInfoCathe("City5");
//
        getWeather("City1");
        getWeather("City2");
        getWeather("City3");

        printInfo();

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

    public static void updateInfoCathe(String city) {
        if (!weathersCache.containsKey(city)){
            System.out.println("Город " + city + " еще не сохранен в кэш\n");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите значение температуры: ");
        int temperature = scanner.nextInt();

        System.out.println("Введите значение влажности: ");
        int humidity = scanner.nextInt();

        weathersCache.get(city).setTemperature(temperature);
        weathersCache.get(city).setHumidity(humidity);

        System.out.println("Iнформация о погоде обновлена  " +"[ Город: " + city + "  Температура: " + temperature + "  Влажность: " + humidity + " ]\n");
    }

    public static void removeInfoCathe(String city) {
        if (weathersCache.containsKey(city)) {
            weathersCache.remove(city);
            System.out.println("Город " + city + " удален из кэша\n");
        } else {
            System.out.println("Город " + city + " еще не сохранен в кэш\n");
        }
    }

    public static void printInfo() {
        System.out.println("// Iнформация о погоде в городах   ------------------------------------------" );

        for (WeatherData weatherData: weathersCache.values()) {
            System.out.println("[ Город: " + weatherData.getCity() + "  Температура: " + weatherData.getTemperature() + "  Влажность: " + weatherData.getHumidity() + " ]");
        }

        System.out.println("-------------------------------------------------------------------------------");
    }

}
