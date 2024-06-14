package faang.school.godbless.caching;

import static faang.school.godbless.caching.WeatherDataService.*;

public class Main {

    public static void main(String[] args) {
        updateWeatherInfo("city1", new WeatherData("city1", 10.0, 10.0));
        updateWeatherInfo("city2", new WeatherData("city2", 20.0, 20.0));
        updateWeatherInfo("city3", new WeatherData("city3", 30.0, 30.0));

        getInfoByCity("city1");
        getInfoByCity("city4");

        listAllCities();
    }
}
