package faang.school.godbless;

import java.util.Random;

public class OutsourcedService {
    public static WeatherData requestToService(String nameCity){
        return new WeatherData(nameCity, new Random().nextDouble(100), new Random().nextDouble(100));
    }
}
