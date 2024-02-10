package faang.school.godbless.main.cashing;

public class MockData {

    public static WeatherData getData(String city) {
        return new WeatherData(city, - 40 + (int) (Math.random()*80), (int) (Math.random()*100));
    }
}
