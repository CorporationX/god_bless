package school.faang.bjs2_69948;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String [] args) {
        try {
            var provider = new WeatherService();
            var cache = new StandardWeatherCache(provider);

            var cacheExpiryMillis = 5000;

            System.out.println(cache.getWeatherData("Moscow", cacheExpiryMillis));
            System.out.println(cache.getWeatherData("Moscow", cacheExpiryMillis));
            Thread.sleep(5000);
            System.out.println(cache.getWeatherData("Moscow", cacheExpiryMillis));
        } catch (InterruptedException ex) {
            log.warn(ex.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}