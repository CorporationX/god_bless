package Hash;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> cities = new HashMap<>();

    public static void main(String[] args) {

        WeatherData weatherData1 = new WeatherData("Moscow", 14, 30);
        WeatherData weatherData2 = new WeatherData("Kaliningrad", 17, 18);
        WeatherData weatherData3 = new WeatherData("Vladivostok", 29, 31);

        cities.put("Moscow", weatherData1);
        cities.put("Kaliningrad", weatherData2);
        cities.put("Vladivostok", weatherData3);

        removeWeather("Kaliningrad");

        updateWeather("Moscow", new WeatherData("Moscow", 15, 5));

        System.out.println(showCityWeather("Moscow"));

        showAllCityWeather();
    }

    public static WeatherData showCityWeather(String city) {
        if (!cities.containsKey(city)) {
            cities.put(city, MockService(city));
        }
        return cities.get(city);
    }

    private static WeatherData MockService(String city){
        return new WeatherData(city, -1, 1);
    }

    public static void updateWeather(String city, WeatherData weatherData){
        cities.put(city, weatherData);
    }

    public static void removeWeather(String city){
        if(cities.containsKey(city)){
            cities.remove(city);
        }else{
            System.out.println("There is no such city.");
        }
    }

    public static void showAllCityWeather(){
        for (Map.Entry<String, WeatherData> entry: cities.entrySet()){
            System.out.print(entry.getKey() + " ");
        }
        System.out.println();
    }

}
