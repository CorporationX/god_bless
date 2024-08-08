package faang.school.godbless.BJS218910;

import java.util.Random;

public class MokClass {
    public static WeatherData addStub(String city){
        Random random = new Random();
        return new WeatherData(city, random.nextInt(-50, 50), random.nextInt(0, 100));
    }
}
