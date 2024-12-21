package derschrank.sprint01.task11.bjstwo_44817;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("\nnew StandardWeatherCache()");
        printWeather(new StandardWeatherCache());

        System.out.println("\nnew FrequentUpdateWeatherCache()");
        printWeather(new FrequentUpdateWeatherCache());

    }

    public static void printWeather(WeatherCache weatherCache) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.format("%s | %s | %s%n",
                    weatherCache.getWeatherData("Moscow"),
                    weatherCache.getWeatherData("London"),
                    weatherCache.getWeatherData("Berlin"));
            Thread.sleep(300);
        }
    }
}
