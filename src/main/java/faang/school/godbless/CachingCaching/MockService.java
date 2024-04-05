package faang.school.godbless.CachingCaching;

public class MockService {
    public static WeatherData getCache(){
        return new WeatherData("city", 20.0, 30.0);
    }
}
