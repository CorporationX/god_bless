package faang.school.godbless.Sprint_1.JavaHashMap.BJS2_8635;

class WeatherService {
    public WeatherData getWeather(String city) {
        System.out.println("Данные о погоде в: " + city);
        return new WeatherData(city, Math.random() * 30, Math.random() * 100);
    }
}
