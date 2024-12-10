package school.faang.sprint1.task_44289;

public class Main {
    static long SLEEP_DURATION = 2000;

    public static void main(String[] args) throws InterruptedException {
        WeatherCacheTemplate standardCaching = new StandardWeatherCache();
        WeatherCacheTemplate frequentCaching = new FrequentUpdateWeatherCache();

        WeatherData almatyWeather = standardCaching.fetchWeatherData("Almaty");
        WeatherData seattleWeather = standardCaching.fetchWeatherData("Seattle");
        boolean isAlmatyWeatherValid = almatyWeather == standardCaching.fetchWeatherData("Almaty");
        System.out.println(
                "is almaty weather valid " + isAlmatyWeatherValid
        );
        boolean isSeattleWeatherValid = seattleWeather == standardCaching.fetchWeatherData("Seattle");
        System.out.println(
                "is seattle weather valid " + isSeattleWeatherValid
        );
        WeatherData philadelphiaWeather = frequentCaching.fetchWeatherData("Philadelphia");
        Thread.sleep(SLEEP_DURATION);
        boolean isPhiladelphiaWeatherValid = philadelphiaWeather == frequentCaching.fetchWeatherData("Philadelphia");
        System.out.println(
                "is Philadelphia weather valid " + isPhiladelphiaWeatherValid
        );
    }
}
