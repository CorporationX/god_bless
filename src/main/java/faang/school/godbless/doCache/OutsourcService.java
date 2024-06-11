package faang.school.godbless.doCache;

import faang.school.godbless.WeatherData;

import java.util.Random;

public class OutsourcService {
    public static WeaterData requestToService(String nameCity){
        return new WeaterData(nameCity, new Random().nextDouble(100), new Random().nextDouble(100));
    }
}
