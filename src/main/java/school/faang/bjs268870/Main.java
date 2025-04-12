package school.faang.bjs268870;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        WeatherCacheTemplate weatherCacheTemplate = new StandardWeatherCache();
        WeatherData weatherData1 = weatherCacheTemplate.getWeatherData("Almaty", 1000);
        System.out.println(weatherData1);
        weatherCacheTemplate.forceUpdateWeather("Almaty");
        System.out.println(weatherCacheTemplate.cache.get("Almaty"));
        Thread.sleep(500);
        WeatherData weatherData2 = weatherCacheTemplate.getWeatherData("Almaty", 1000);
        System.out.println(weatherData2);
        WeatherCacheTemplate weatherCacheTemplate1 = new FrequentUpdateWeatherCache();
        WeatherData weatherData3 = weatherCacheTemplate1.getWeatherData("Astana", 1000);
        System.out.println(weatherData3);
        Thread.sleep(500);
        WeatherData weatherData4 = weatherCacheTemplate1.getWeatherData("Astana", 1000);
        System.out.println(weatherData4);

    }
}
