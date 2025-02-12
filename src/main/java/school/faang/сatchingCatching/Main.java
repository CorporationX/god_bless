package school.faang.сatchingCatching;

public class Main {
    public static void main(String[] args) {

        WeatherCacheTemplate weatherCache = new StandardWeatherCache();

        long maxCacheAgeMillis = 5 * 60 * 1000;

        WeatherData saintPetersburgWeather = weatherCache.getWeatherData("Saint-Petersburg", maxCacheAgeMillis);
        System.out.println("City: " + saintPetersburgWeather.getCity());
        System.out.println("Temperature: " + saintPetersburgWeather.getTemperature());
        System.out.println("Humidity: " + saintPetersburgWeather.getHumidity());
        System.out.println("Time to receipt: " + saintPetersburgWeather.getTimestamp());

        WeatherData moscowWeather = weatherCache.getWeatherData("Moscow", maxCacheAgeMillis);
        System.out.println("City: " + moscowWeather.getCity());
        System.out.println("Temperature: " + moscowWeather.getTemperature());
        System.out.println("Humidity: " + moscowWeather.getHumidity());
        System.out.println("Time to receipt: " + moscowWeather.getTimestamp());
    }
}

