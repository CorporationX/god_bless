package faang.school.godbless.task.caching.caching;

import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class MockWeatherDataCenterForTest {
    private final Random random;

    public WeatherData getRandomWeatherDataByCityMock(String city) {
        double temperature = random.nextDouble() * (45.0 - -20.0) + -20.0;
        temperature = Math.round(temperature * 100) / 100.0;
        double humidity = random.nextDouble() * (95.0 - 5.0) + 5;
        humidity = Math.round(humidity * 100) / 100.0;

        return new WeatherData(city, temperature, humidity);
    }
}
