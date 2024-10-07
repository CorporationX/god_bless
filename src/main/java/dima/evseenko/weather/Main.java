package dima.evseenko.weather;

public class Main {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService();
        System.out.println(weatherService.getWeatherData("Москва") + "\n");

        weatherService.updateWeatherData("Краснодар");
        weatherService.updateWeatherData("Ростов-на-Дону");
        weatherService.printCachedWeatherData();

        weatherService.deleteWeatherData("Москва");
        weatherService.printCachedWeatherData();
    }
}
