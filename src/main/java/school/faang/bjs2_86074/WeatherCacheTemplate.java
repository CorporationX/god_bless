package school.faang.bjs2_86074;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public abstract class WeatherCacheTemplate {
    private Map<String, WeatherData> weatherDataCash;

    public abstract void isCacheExpired(WeatherData data, long maxCacheAgeMillis);

}
