package faang.school.godbless.bjs219190;

public class ExternalService {
    public static WeatherData getWeatherData(String city) {
        System.out.println("Fetching data for " + city + "...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new WeatherData(city, (float) Math.random() * 40, (float) (Math.random() * 100));
    }
}
