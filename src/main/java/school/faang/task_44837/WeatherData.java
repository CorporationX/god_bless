package school.faang.task_44837;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherData {

    /**
     * Название города.
     */
    private String city;

    /**
     * Текущая температура.
     */
    private double temperature;

    /**
     * Текущая влажность.
     */
    private double humidity;

    /**
     * Время получения данных (в миллисекундах), чтобы отслеживать срок их актуальности.
     */
    private long timestamp;
}
