package faang.school.godbless.BJS2_5091;

public class Main {
    public static void main(String[] args) {
        WeatherCache cache = new WeatherCache();

        WeatherData londonWeather = cache.getWeatherByCity("London");
        System.out.println(londonWeather);

        cache.updateWeather(new WeatherData("Stambul", 12, 44));
        cache.printAllWeatherCity();

        cache.removeWeather("Stambul");
        cache.printAllWeatherCity();
    }
}
