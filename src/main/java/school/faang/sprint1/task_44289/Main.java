package school.faang.sprint1.task_44289;

public class Main {
    static long SLEEP_DURATION = 2000;

    public static void main(String[] args) throws InterruptedException {
        WeatherCacheTemplate standardCaching = new StandardWeatherCache();
        WeatherCacheTemplate frequentCaching = new FrequentUpdateWeatherCache();

        WeatherData almatyWeather = standardCaching.fetchWeatherData("Almaty");

        WeatherData seattleWeather = standardCaching.fetchWeatherData("Seattle");

        WeatherData philadelphiaWeather = frequentCaching.fetchWeatherData("Philadelphia");

        boolean isAlmatyWeatherValid = almatyWeather == standardCaching.fetchWeatherData("Almaty");
        System.out.println(
            "is almaty weather valid " + isAlmatyWeatherValid
        );

        boolean isSeattleWeatherValid = seattleWeather == standardCaching.fetchWeatherData("Seattle");
        System.out.println(
                "is seattle weather valid " + isSeattleWeatherValid
        );
        Thread.sleep(SLEEP_DURATION);
        WeatherData newPhiladelphiaWeather = frequentCaching.fetchWeatherData("Philadelphia");
        boolean isPhiladelphiaWeatherValid = philadelphiaWeather == frequentCaching.fetchWeatherData("Philadelphia");
        philadelphiaWeather = newPhiladelphiaWeather;
        System.out.println(
                "is Philadelphia weather valid " + isPhiladelphiaWeatherValid
        );



        // applying clear
        frequentCaching.clearExpiredCache(1);
        isPhiladelphiaWeatherValid = philadelphiaWeather == frequentCaching.fetchWeatherData("Philadelphia");
        System.out.println(
                "is Philadelphia weather valid " + isPhiladelphiaWeatherValid
        );
    }
}
