package school.faang.BSJ2_87000;

import lombok.Getter;

public record WeatherData(@Getter String city,
                          @Getter double temperature,
                          @Getter double humidity,
                          @Getter long timestamp) {
}
