package faang.school.godbless.Task_9;

public class WeatherInfo {
    WeatherData wInfo(String nameOfCity) {
        return new WeatherData(nameOfCity, (int) (Math.random() * 50), (int) (Math.random() * 50));
    }
}
