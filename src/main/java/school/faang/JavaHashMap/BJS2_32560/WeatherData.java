package school.faang.JavaHashMap.BJS2_32560;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;

    @Override
    public String toString() {
        return String.format("В городе %s температура %d градусов Цельсия, влажность %d процентов",
                city, temperature, humidity);
    }
}
