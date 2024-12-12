package school.faang.task_44837;

public interface WeatherProvider {

    /**
     * Возвращает свежие данные о погоде
     */
    public WeatherData fetchWeatherData(String city);
}
