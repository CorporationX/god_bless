package faang.school.godbless.Task_9;

public class WeatherInfo {
    WeatherData wInfo(String nameOfCity) {
        Integer a = (int)(Math.random() * 50);
        Integer b = (int)(Math.random() * 50);
        return new WeatherData(nameOfCity, a, b);
    }
}
