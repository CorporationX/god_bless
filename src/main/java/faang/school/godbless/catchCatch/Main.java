package faang.school.godbless.catchCatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static Map<String, WeatherData> weatherData = new HashMap<>();

    public static void main(String[] args) {
        List<WeatherData> weatherDataList = new ArrayList<>();
        weatherDataList.add(new WeatherData("London", 15, 90));
        weatherDataList.add(new WeatherData("Warsaw", -10, 80));
        weatherDataList.add(new WeatherData("New York", 20, 95));
        weatherDataList.add(new WeatherData("Sidney", 32, 85));
        weatherDataList.add(new WeatherData("Stockholm", 5, 90));

        weatherData = mapWeatherDataLambda.apply(weatherDataList);
        System.out.println(getWeatherData(weatherData, "Paris"));
        updateWeatherData(weatherData, "London", 25, 80);
        removeWeatherData(weatherData, "Warsaw");
        printAllWeatherData(weatherData);
    }

    public static WeatherData getWeatherData(Map<String, WeatherData> weatherMap, String cityName) {
        if (weatherMap.get(cityName) == null) {
//            weatherMap.put(cityName, weatherDataNotExist(cityName));
            weatherMap.put(cityName, new WeatherService().weatherDataNotExist(cityName));
        }
        return weatherMap.get(cityName);
    }

    public static void updateWeatherData(Map<String, WeatherData> weatherDataMap, String cityName, float temperature, float humidity) {
        WeatherData dataToUpdate = new WeatherData(cityName, temperature, humidity);
        weatherDataMap.put(cityName, dataToUpdate);
    }

    public static void removeWeatherData(Map<String, WeatherData> weatherDataMap, String cityName) {
        weatherDataMap.remove(cityName);
    }

    public static void printAllWeatherData(Map<String, WeatherData> weatherDataMap) {
        weatherDataMap.entrySet().forEach(System.out::println);
    }

    public static Function<List<WeatherData>, Map<String, WeatherData>> mapWeatherDataLambda = weatherDataList ->
            weatherDataList.stream()
                    .collect(Collectors.toMap(WeatherData::getCity, Function.identity()));

//Without lambda
//    public static Map<String, WeatherData> mapWeatherData(List<WeatherData> weatherDataList) {
//        Map<String, WeatherData> weatherMap = new HashMap<>();
//        for (WeatherData data : weatherDataList) {
//            weatherMap.put(data.getCity(), data);
//        }
//        return weatherMap;
//    }
}
