package school.faang.weather;

public record WeatherData(String city,
                          Double temperature,
                          Double humidity,
                          Long timestamp) {

}
