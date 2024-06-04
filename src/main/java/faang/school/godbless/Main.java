package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<String, WeatherData> weatherInCities = new HashMap<>();
    public static void main(String[] args) {
        addWeatherInCities("London", new WeatherData("London", 34.4, 50.0));
        addWeatherInCities("Parish", new WeatherData("Parish", 54.4, 77.0));
        addWeatherInCities("Rim", new WeatherData("Rim", 31.3, 30.0));
        addWeatherInCities("New York", new WeatherData("New York", 23.5, 30.0));
        addWeatherInCities("Moscow", new WeatherData("Moscow", 15.4, 20.0));

        System.out.println(weatherInCities);
        System.out.println("_________________");

        System.out.println(infoWeather("Mosco"));

        System.out.println(weatherInCities);
        System.out.println("_________________");

        update("Rim", new WeatherData("Rim", 11.3, 90.0));

        System.out.println(weatherInCities);
        System.out.println("_________________");

        delete("London");

        System.out.println(weatherInCities);
        System.out.println("_________________");

        System.out.println(allCities());

    }
    static String infoWeather(String nameCity){
        if (!weatherInCities.containsKey(nameCity)) {
            addWeatherInCities(nameCity, OutsourcedService.requestToService(nameCity));
        }
        return weatherInCities.get(nameCity).getTemperature() + " " + weatherInCities.get(nameCity).getHumidity();
    }

    static void addWeatherInCities(String nameCity, WeatherData weatherData){
        weatherInCities.put(nameCity, weatherData);
    }

    static void update(String nameCity, WeatherData weatherData){   // обновление информации о погоде в кэше для определённого города;
        weatherInCities.get(nameCity).setTempAndHumi(weatherData.getTemperature(), weatherData.getHumidity());
    }
    static void delete(String nameCity){
        weatherInCities.get(nameCity).setTempAndHumi(null, null);
    }

    static List<String> allCities(){
        List<String> citiesList = new ArrayList<>();
        for (var map:weatherInCities.entrySet()) {
            if (map.getValue().getHumidity() != null & map.getValue().getTemperature() != null){
                citiesList.add(map.getKey());
            }
        }return citiesList;
    }
}
