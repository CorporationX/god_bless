package school.faang.bjs2_86074;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Map;

import static school.faang.bjs2_86074.ConstantWearher.MAX_HUMIDITY;
import static school.faang.bjs2_86074.ConstantWearher.MAX_TEMPARATURE;
import static school.faang.bjs2_86074.ConstantWearher.MIN_HUMIDITY;
import static school.faang.bjs2_86074.ConstantWearher.MIN_TEMPARATURE;

@SuperBuilder
public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return false;
    }

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperatureRandom = MIN_TEMPARATURE - Math.random() * (MAX_TEMPARATURE - MIN_TEMPARATURE + 1);
        double humidityRandom = MIN_HUMIDITY - Math.random() * (MAX_HUMIDITY - MIN_HUMIDITY + 1);
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperatureRandom, humidityRandom, timestamp);
    }
}
