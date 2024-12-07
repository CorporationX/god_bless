package school.faang.task_44845;

import school.faang.task_44845.entity.WeatherData;

public class Main {
    public static void main(String[] args) {
        WeatherProvider provider = new WeatherService();


        WeatherCacheTemplate standardCache = new StandardWeatherCache(provider);

        String city = "New York";
        long maxCacheAgeMillis = 5000;
        System.out.println("StandardWeatherCache:");
        WeatherData standardData1 = standardCache.getWeatherData(city, maxCacheAgeMillis);
        System.out.println("1st fetch: " + standardData1.getHumidity() + " " + standardData1.getTemperature());
        WeatherData standardData2 = standardCache.getWeatherData(city, maxCacheAgeMillis);
        System.out.println("2nd fetch (from cache): " + standardData2.getHumidity() + " " + standardData2.getTemperature());

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WeatherData standardData3 = standardCache.getWeatherData(city, maxCacheAgeMillis);
        System.out.println("3rd fetch (fresh data):" + standardData3.getHumidity() + " " + standardData3.getTemperature());

        WeatherCacheTemplate frequentCache = new FrequentUpdateWeatherCache(provider);

        System.out.println("\n FrequentUpdateWeatherCache:");
        WeatherData frequentData1 = frequentCache.getWeatherData(city, maxCacheAgeMillis);
        System.out.println("1st fetch: " + frequentData1.getHumidity() + " " + frequentData1.getTemperature());
        WeatherData frequentData2 = frequentCache.getWeatherData(city, maxCacheAgeMillis);
        System.out.println("2nd fetch (always fresh): " + frequentData2.getHumidity() + " " + frequentData2.getTemperature());


    }

}
