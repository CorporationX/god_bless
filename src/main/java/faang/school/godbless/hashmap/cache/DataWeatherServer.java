package faang.school.godbless.hashmap.cache;

import lombok.Data;

@Data
public class DataWeatherServer {
    public WeatherData getData(String cityName){
        return new WeatherData("test", 0.0, 0.0);
    }
}
