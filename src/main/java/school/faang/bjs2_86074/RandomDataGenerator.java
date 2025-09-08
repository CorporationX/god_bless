package school.faang.bjs2_86074;

import static school.faang.bjs2_86074.ConstantWearher.MAX_HUMIDITY;
import static school.faang.bjs2_86074.ConstantWearher.MAX_TEMPARATURE;
import static school.faang.bjs2_86074.ConstantWearher.MIN_HUMIDITY;
import static school.faang.bjs2_86074.ConstantWearher.MIN_TEMPARATURE;

public class RandomDataGenerator {
    public static WeatherData generatorData(String city) {
        double temperatureRandom =  Math.random() * (MAX_TEMPARATURE - MIN_TEMPARATURE + 1) + MIN_TEMPARATURE ;
        double humidityRandom = Math.random() * (MAX_HUMIDITY - MIN_HUMIDITY + 1);
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperatureRandom, humidityRandom, timestamp);
    }
}
