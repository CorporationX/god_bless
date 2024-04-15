package faang.school.godbless.catchCatch;

public class WeatherService {

    public WeatherData weatherDataNotExist(String cityName) {
        return new WeatherData(cityName, (float) (Math.random() * 100), (float) (Math.random() * 100));
    }
}
