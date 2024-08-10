package faang.school.godbless;

import faang.school.godbless.Weather.WeatherData;
import java.util.*;

public class Application {
    public static Map<String, WeatherData> weatherDataMap = new HashMap<>();

    public static WeatherData getWeatherData(String city) {
        if (weatherDataMap.containsKey(city)) {
            return weatherDataMap.get(city);
        } else {
            WeatherData weatherData = weatherCity(city);
            weatherDataMap.put(city, weatherData);
            return weatherData;
        }
    }

    public static  WeatherData weatherCity(String city) {
        double temperature = Math.random() * 30;
        double humidity = Math.random() * 100;
        return new WeatherData(city, temperature, humidity);
    }

    public static void updateWeatherData(String city, double temperature, double humidity) {
        WeatherData weatherData = new WeatherData(city, temperature, humidity);
        weatherDataMap.put(city, weatherData);
    }

    public static void removeWeatherData(String city) {
        weatherDataMap.remove(city);
    }

    public static  Set<String> getAllCities() {
        return weatherDataMap.keySet();
    }



    public static void main(String[] args) {
        Hero hero1 = new Hero("Sir Christian", "Castle", 500, 10);
        Hero hero2 = new Hero("Vey", "Necropolis", 300, 8);

        hero1.addCreature(new Pikeman(), 10);
        hero1.addCreature(new Swordman(), 5);

        hero2.addCreature(new Griffin(), 6);
        hero2.addCreature(new Angel(), 2);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Hero winner = battlefield.battle();

        if (winner != null) {
            System.out.println("Winner: " + winner.getArmy());
        } else {
            System.out.println("It's a draw!");
        }
    }
}
