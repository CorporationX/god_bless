package school.faang.task_56899;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        StandardWeatherCache standardWeatherCache = new StandardWeatherCache();
        standardWeatherCache.getWeatherData("New York", 10000);
        standardWeatherCache.getWeatherData("Moscow", 8000);
        standardWeatherCache.printAllWeatherData();

        System.out.println();
        Thread.sleep(3000);

        System.out.println(standardWeatherCache.getWeatherData("Moscow", 1000));
        System.out.println(standardWeatherCache.getWeatherData("Moscow", 10000));
        standardWeatherCache.cleanExpiredCache(1000);
        standardWeatherCache.printAllWeatherData();
        System.out.println();

        FrequentUpdateWeatherCache frequentUpdateWeatherCache = new FrequentUpdateWeatherCache();
        frequentUpdateWeatherCache.getWeatherData("Amsterdam", 15000);
        frequentUpdateWeatherCache.getWeatherData("Moscow", 25000);
        frequentUpdateWeatherCache.cleanExpiredCache(50000);
        frequentUpdateWeatherCache.printAllWeatherData();
    }
}
