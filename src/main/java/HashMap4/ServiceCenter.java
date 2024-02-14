package HashMap4;

import java.util.Random;

public class ServiceCenter {
    public WeatherData weatherCenter(String city){
        return new WeatherData(city,new Random().nextInt(-5, 31), new Random().nextInt(0,101));
    }
}
