package faang.school.godbless;


import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        HashMap<String, WeatherData> weatherData = new HashMap<>();

        WeatherData data1 = new WeatherData("Almaty", 22, 70);
        WeatherData data2 = new WeatherData("Moscow", 25, 65);


        WeatherData.updateWeatherData(weatherData, "Berlin", data1);
        WeatherData.updateWeatherData(weatherData, "Tokyo", data2);

        System.out.println("Все города мапы");
        WeatherData.printAllCities(weatherData);

        System.out.println("Получение по getWeatherData");
        System.out.println(WeatherData.getWeatherData(weatherData, "Berlin"));

        System.out.println("Получение по неизвестному городу");
        System.out.println(WeatherData.getWeatherData(weatherData, "Chicago"));


        WeatherData newData = new WeatherData("New York", 20, 75);
        WeatherData.updateWeatherData(weatherData, "New York", newData);

        WeatherData.removeWeatherData(weatherData, "Los Angeles");

        System.out.println("Вывод списка всех городов");
        WeatherData.printAllCities(weatherData);

        System.out.println("Информация о Берлине");
        System.out.println(WeatherData.getWeatherData(weatherData, "Berlin"));

        System.out.println("Информация Los Angeles:");
        System.out.println(WeatherData.getWeatherData(weatherData, "Los Angeles"));

  }
}