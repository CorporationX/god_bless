package faang.school.godbless.BJS2_8643;


import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> cache = new HashMap<>();

    public static void main(String[] args) {

        addCity("Рыбинск", 23, 45);
        addCity("Питер", 23, 88);
        addCity("Егорьевск", 23, 43);
        addCity("Пятигорск", 23, 64);
        addCity("Новгород", 23, 12);
        addCity("Москва", 23, 23);

        printInfoAboutAllCities();

        removeInfoAboutCity("Москва");

        System.out.println(getInfoAboutCity("Рыбинск"));
        System.out.println();

        refreshInfoAboutCity("Питер", 13, 97);

        System.out.println(getInfoAboutCity("Питер"));
        System.out.println();

        printInfoAboutAllCities();
    }

    public static void addCity(String city, int temperature, int humidity) {
        cache.put(city, new WeatherData(city, temperature, humidity));
    }

    public static String getInfoAboutCity(String city) {
        WeatherData cityWeatherData;

        if (!cache.containsKey(city)) {
            //запрос к "внешнему сервису" и сохраняем в кэше
            cache.put(city, Service.getInfoFromService());
        }

        cityWeatherData = cache.get(city);

        return "City: " + city +
                "\nHumidity: " + cityWeatherData.getHumidity() +
                "\nTemperature: " + cityWeatherData.getTemperature();
    }

    public static void refreshInfoAboutCity(String city, int temperature, int humidity) {

        if (!cache.containsKey(city)) {
            System.out.println("Данный город отсутствует в базе");
        } else {
            cache.put(city, new WeatherData(city, temperature, humidity));
        }
    }

    public static void removeInfoAboutCity(String city) {

        if (!cache.containsKey(city)) {
            System.out.println("Данный город отсутствует в базе");
        } else {
            cache.remove(city);
        }
    }

    public static void printInfoAboutAllCities() {
        for (var city: cache.entrySet()) {
            System.out.println(getInfoAboutCity(city.getKey()));
            System.out.println("-".repeat(20));
        }
    }
}
