package faang.school.godbless.java_sql.task_4;

public class WeatherRepository {
    static WeatherData getWeatherFromCity(String city) {
        return new WeatherData(city,0, 0);
    }
}
