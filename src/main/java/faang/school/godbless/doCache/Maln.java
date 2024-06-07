package faang.school.godbless.doCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Maln {
    private static Map<String, WeaterData> weatherInCities = new HashMap<>();

    public static void main(String[] args) {
        addWeatherInCities(new WeaterData("London", 34.4, 50.0));
        addWeatherInCities(new WeaterData("Parish", 54.4, 77.0));
        addWeatherInCities(new WeaterData("Rim", 31.3, 30.0));
        addWeatherInCities(new WeaterData("New York", 23.5, 30.0));
        addWeatherInCities(new WeaterData("Moscow", 15.4, 20.0));

        System.out.println(weatherInCities);
        System.out.println("_________________");

        System.out.println(infoWeather("Mosco"));

        System.out.println(weatherInCities);
        System.out.println("_________________");

        update("Rim", new WeaterData("Rim", 11.3, 90.0));

        System.out.println(weatherInCities);
        System.out.println("_________________");

        delete("London");

        System.out.println(weatherInCities);
        System.out.println("_________________");

        System.out.println(allCities());

    }

    static String infoWeather(String nameCity) {
        if (!weatherInCities.containsKey(nameCity)) {
            addWeatherInCities(OutsourcService.requestToService(nameCity));
        }
        return weatherInCities.get(nameCity).getTemperature() + " " + weatherInCities.get(nameCity).getHumidity();
    }

    static void addWeatherInCities(WeaterData weatherData) {
        weatherInCities.put(weatherData.getCity(), weatherData);
        infoWeather(weatherData.getCity());
    }

    static void update(String nameCity, WeaterData weatherData) {   // обновление информации о погоде в кэше для определённого города;
        if (weatherData.getCity().equals(nameCity)) {
            weatherInCities.get(nameCity).setTempAndHum(weatherData.getTemperature(), weatherData.getHumidity());
        } else
            throw new IllegalArgumentException("Введены некорректные данные");
    }

    static void delete(String nameCity) {
        weatherInCities.get(nameCity).setTempAndHum(null, null);
    }

    static List<String> allCities() {
        List<String> citiesList = new ArrayList<>();
        for (var map : weatherInCities.entrySet()) {
            if (map.getValue().getHumidity() != null & map.getValue().getTemperature() != null) {
                citiesList.add(map.getKey());
            }
        }
        return citiesList;
    }
}
