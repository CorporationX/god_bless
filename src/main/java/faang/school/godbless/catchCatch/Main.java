package faang.school.godbless.catchCatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Map<String, WeatherData> weatherMap = new HashMap<>();
        List<WeatherData> weatherDataList = new ArrayList<>();
        weatherDataList.add(new WeatherData("London", 15, 90));
        weatherDataList.add(new WeatherData("Warsaw", -10, 80));
        weatherDataList.add(new WeatherData("New York", 20, 95));
        weatherDataList.add(new WeatherData("Sidney", 32, 85));
        weatherDataList.add(new WeatherData("Stockholm", 5, 90));

        weatherMap = mapWeatherDataLambda.apply(weatherDataList);
        System.out.println(getWeatherData(weatherMap, "Paris"));
        weatherMap = updateWeatherData(weatherMap, "London", 25, 80);
        weatherMap = removeWeatherData(weatherMap, "Warsaw");
        printAllWeatherData(weatherMap);
    }

    public static WeatherData getWeatherData(Map<String, WeatherData> weatherMap, String cityName) {
        if (weatherMap.get(cityName) == null) {
            weatherMap.put(cityName, weatherDataNotExist(cityName));
        }
        return weatherMap.get(cityName);
    }

    public static Map<String, WeatherData> updateWeatherData(Map<String, WeatherData> weatherDataMap, String cityName, float temperature, float humidity) {
        WeatherData dataToUpdate = new WeatherData(cityName, temperature, humidity);
        weatherDataMap.put(cityName, dataToUpdate);
        return weatherDataMap;
    }

    public static Map<String, WeatherData> removeWeatherData(Map<String, WeatherData> weatherDataMap, String cityName) {
        weatherDataMap.remove(cityName);
        return weatherDataMap;
    }

    public static void printAllWeatherData(Map<String, WeatherData> weatherDataMap) {
        weatherDataMap.entrySet().forEach(System.out::println);
    }

    public static WeatherData weatherDataNotExist(String cityName) {
        return new WeatherData(cityName, (float) (Math.random() * 100), (float) (Math.random() * 100));
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
