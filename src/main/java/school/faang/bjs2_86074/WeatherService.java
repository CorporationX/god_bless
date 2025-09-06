package school.faang.bjs2_86074;

import java.util.HashMap;
import java.util.Map;

import static school.faang.bjs2_86074.ConstantWearher.MAX_HUMIDITY;
import static school.faang.bjs2_86074.ConstantWearher.MAX_TEMPARATURE;
import static school.faang.bjs2_86074.ConstantWearher.MIN_HUMIDITY;
import static school.faang.bjs2_86074.ConstantWearher.MIN_TEMPARATURE;

public class WeatherService implements WeatherProvider {

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperatureRandom = MIN_TEMPARATURE - Math.random() * (MAX_TEMPARATURE - MIN_TEMPARATURE + 1);
        double humidityRandom = MIN_HUMIDITY - Math.random() * (MAX_HUMIDITY - MIN_HUMIDITY + 1);
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperatureRandom, humidityRandom, timestamp);
    }

    //просто для примера. Примерная логика шаблонного метода получится такая?
    // то есть определяем стратегию вначале и потом уже вызываем метод getWeatherData из абстрактного класса
    // который подтянет нужный isCacheExpired? все это делается в сервисе и тут определяется стратегия?
    public void approximateLogicOfUse() {
        WeatherCacheTemplate weatherCacheTemplate = new StandardWeatherCache();
        weatherCacheTemplate.getWeatherData("Москва", 100000);
    }

}
