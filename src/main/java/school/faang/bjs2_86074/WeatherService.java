package school.faang.bjs2_86074;

public class WeatherService implements WeatherProvider {

    @Override
    public WeatherData fetchWeatherData(String city) {
        return RandomDataGenerator.generatorData(city);
    }
}
