package school.faang.cachecache;

import java.util.Random;

/**
 * Класс который реализует метод fetchWeatherData и имитирует получение данных о погоде
 */
public class WeatherService implements WeatherProvider {

    /**
     * @param city город в котором нужно узнать погоду
     * @return возвращает свежие данные о погоде для указанного города
     */
    @Override
    public WeatherData fetchWeatherData(String city) {
        Random rand = new Random();
        //заглушка, которая предпологает,что у нас зима
        double temperature = rand.nextDouble(-25.0, 0.0);
        double humidity = rand.nextDouble(50.0, 70.0);
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
