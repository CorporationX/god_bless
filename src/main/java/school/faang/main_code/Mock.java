package school.faang.main_code;

import lombok.Data;

@Data
public class Mock {
    WeatherData weatherData;
    public WeatherData mock() {
        return new WeatherData("Machachkala", 18, 19);
    }
}
