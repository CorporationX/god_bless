package school.faang.bjs2_86085;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeatherProvider provider = new WeatherService();
        WeatherCacheTemplate standardCache = new StandardWeatherCache(provider);

        System.out.println("== Testing StandardWeatherCache ==");
        WeatherData data1 = standardCache.getWeatherData("Paris", 3000);
        System.out.println("First call: " + data1);
        WeatherData data2 = standardCache.getWeatherData("Paris", 3000);
        System.out.println("Second call: " + data2);
        System.out.println("Data equal: " + data1.equals(data2));
        Thread.sleep(3500);
        WeatherData data3 = standardCache.getWeatherData("Paris", 3000);
        System.out.println("After timeout: " + data3);
        System.out.println("Data equal after timeout: " + data1.equals(data3));

        WeatherCacheTemplate frequentCache = new FrequentUpdateWeatherCache(provider);

        System.out.println("\n== Testing FrequentUpdateWeatherCache ==");
        WeatherData data4 = frequentCache.getWeatherData("London", 1000);
        System.out.println("First call: " + data4);
        WeatherData data5 = frequentCache.getWeatherData("London", 1000);
        System.out.println("Second call: " + data5);
        System.out.println("Data equal: " + data4.equals(data5));
        Thread.sleep(1500);
        WeatherData data6 = frequentCache.getWeatherData("London", 1000);
        System.out.println("After timeout: " + data6);
        System.out.println("Data equal after timeout: " + data4.equals(data6));
    }
}