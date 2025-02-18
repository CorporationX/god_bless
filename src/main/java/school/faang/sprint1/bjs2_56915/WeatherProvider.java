package school.faang.sprint1.bjs2_56915;

import lombok.NonNull;

public interface WeatherProvider {
    WeatherData fetchWeatherData(@NonNull String city);
}
