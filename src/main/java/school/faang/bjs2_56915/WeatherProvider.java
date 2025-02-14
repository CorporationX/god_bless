package school.faang.bjs2_56915;

import lombok.NonNull;

public interface WeatherProvider {
    WeatherData fetchWeatherData(@NonNull String city);
}
