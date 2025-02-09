package school.faang;

public class Main {
    public static void main(String[] args) {

        WeatherCacheTemplate weatherCache = new StandardWeatherCache();

        long maxCacheAgeMillis = 5 * 60 * 1000;

        WeatherData saintPWeather = weatherCache.getWeatherData("Saint-Petersburg", maxCacheAgeMillis);
        System.out.println("City: " + saintPWeather.getCity());
        System.out.println("Temperature: " + saintPWeather.getTemperature());
        System.out.println("Humidity: " + saintPWeather.getHumidity());
        System.out.println("Time to receipt: " + saintPWeather.getTimestamp());

        WeatherData moscowWeather = weatherCache.getWeatherData("Moscow", maxCacheAgeMillis);
        System.out.println("City: " + moscowWeather.getCity());
        System.out.println("Temperature: " + moscowWeather.getTemperature());
        System.out.println("Humidity: " + moscowWeather.getHumidity());
        System.out.println("Time to receipt: " + moscowWeather.getTimestamp());
    }
}
