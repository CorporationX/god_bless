package HashMap4;

import java.util.Random;

public class ServiceCenter {
    public WeatherData weatherCenter(String city){
        Random rnd = new Random();
        return new WeatherData(city,rnd.nextInt(-5, 31), rnd.nextInt(0,101));
    }
}
