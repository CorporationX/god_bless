package school.faang.bjs244816;

public class Main {

    public static void main(String[] args) {
        WeatherCacheTemplate cache = new StandardWeatherCache();
        cache.getWeatherData("New York");
    }
}
