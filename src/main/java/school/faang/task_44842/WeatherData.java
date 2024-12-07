package school.faang.task_44842;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WeatherData {

    /*Создайте класс WeatherData с полями:
    String city — название города;
    double temperature — текущая температура;
    double humidity — текущая влажность;
    long timestamp — время получения данных (в миллисекундах), чтобы отслеживать срок их актуальности.
     */
    private String city;
    private double temperature;
    private double humidity;
    private long timestamp;

    @Override
    public String toString() {
        return "WeatherData{"
                + "city='" + city + '\''
                + ", temperature=" + temperature
                + ", humidity=" + humidity
                +", timestamp=" + timestamp + '}';
    }
}
