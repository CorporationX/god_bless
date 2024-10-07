package school.faang.BJS2_32568_CachingCaching;

public class Main {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService();

        weatherService.updateCityWeather(new WeatherData("New York", 20.0, 60.0));
        weatherService.updateCityWeather(new WeatherData("London", 10.0, 80.0));
        weatherService.updateCityWeather(new WeatherData("Tokyo", 25.0, 50.0));

        System.out.println("All cities weather data:");
        weatherService.printAllCitiesWeathers();

        System.out.println("\nGetting weather data about London:");
        WeatherData londonWeather = weatherService.getCityWeather("London");
        System.out.println(londonWeather);

        weatherService.updateCityWeather(new WeatherData("London", 15.0, 75.0));

        System.out.println("\nAll cities weather after updating weather data about London:");
        weatherService.printAllCitiesWeathers();

        weatherService.removeCityWeather("Tokyo");

        System.out.println("\nAll cities weather after removing weather data about Tokyo:");
        weatherService.printAllCitiesWeathers();
    }
}
