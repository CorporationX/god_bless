package faang.school.godbless.weather;

public record WeatherData(
        String city,
        double temperature,
        int humidity
) {
    public record MockWeather() {
        public static WeatherData getMockWeather() {
            return new WeatherData("Mock", 0.0, 0);
        }
    }
}
