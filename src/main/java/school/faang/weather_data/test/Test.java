package school.faang.weather_data.test;

import school.faang.weather_data.FrequentUpdateWeatherCache;
import school.faang.weather_data.StandardWeatherCache;
import school.faang.weather_data.WeatherCacheTemplate;
import school.faang.weather_data.WeatherData;
import school.faang.weather_data.WeatherProvider;
import school.faang.weather_data.WeatherService;

public class Test {

        public static void main(String[] args) {

            WeatherProvider provider = new WeatherService();
            WeatherCacheTemplate standardCache = new StandardWeatherCache(provider);
            WeatherCacheTemplate frequentCache = new FrequentUpdateWeatherCache(provider);

            System.out.println("Standard cache:");
            WeatherData data1 = standardCache.getWeatherData("Moscow", 5000);
            System.out.println(data1);

            try {
                Thread.sleep(2000);
                WeatherData data2 = standardCache.getWeatherData("Moscow", 5000);
                System.out.println("Same data (from cache): " + data2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("\nFrequent update cache:");
            WeatherData data3 = frequentCache.getWeatherData("London", 10000);
            System.out.println(data3);
            WeatherData data4 = frequentCache.getWeatherData("London", 10000);
            System.out.println("Different data (forced update): " + data4);
        }
}

