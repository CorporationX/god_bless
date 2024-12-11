package school.faang.task_44837;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherData {
    private String city;          // название города
    private double temperature;  //текущая темпа
    private double humidity;   //текущая влажность
    private long timestamp;   //время получения данных (в миллисекундах), чтобы отслеживать срок их актуальности
}
