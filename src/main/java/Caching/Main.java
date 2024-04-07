package Caching;

public class Main {

    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService();
        weatherService.getWeatherInfo("Moscow");
        weatherService.getWeatherInfo("London");
        weatherService.getWeatherInfo("New York");
        weatherService.getWeatherInfo("Saint-Petersburg");
        weatherService.printInfoCache();
        weatherService.updateInfo("London");
        weatherService.printInfoCache();
        weatherService.removeInfo("Moscow");
        weatherService.printInfoCache();
    }
}
