package faang.school.godbless.task.caching.caching;

import java.util.concurrent.ThreadLocalRandom;

public class MockWeatherDataCenterForTest {

    public WeatherData getRandomWeatherDataByCityMock(String city) {
        double temperature = ThreadLocalRandom.current().nextDouble(-20.0, 45.0);
        temperature = Math.round(temperature * 100) / 100.0;
        double humidity = ThreadLocalRandom.current().nextDouble(5.0, 95.0);
        humidity = Math.round(humidity * 100) / 100.0;

        return new WeatherData(city, temperature, humidity);
    }
}
