package faang.school.godbless.BJS2_576;

import lombok.Getter;

@Getter
public class ExternalService {
    public WeatherData getWeatherDataInfo(String city){
        WeatherData weatherData = new WeatherData(city, 12, 50);
        return weatherData;
    }
}