package faang.school.godbless.cachingcaching;

public class WeatherService {
    public WeatherData getWeather(String city) {
        // �������� ��������� ������ �� �������� �������
        double temperature = Math.random() * 40; // ��������� ����������� �� 0 �� 40�C
        double humidity = Math.random() * 100;  // ��������� ��������� �� 0% �� 100%
        return new WeatherData(city, temperature, humidity);
    }
}