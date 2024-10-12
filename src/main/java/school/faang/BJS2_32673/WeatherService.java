package school.faang.BJS2_32673;

class WeatherService {

    public WeatherData fetchWeatherData(String city) {

        return new WeatherData(city, 25.0, 65.0);

    }
}
