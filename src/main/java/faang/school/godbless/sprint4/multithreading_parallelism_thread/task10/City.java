package faang.school.godbless.sprint4.multithreading_parallelism_thread.task10;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class City {

    private String cityName;

    private int location;

    public static Map<String, Integer> durationToCity = new HashMap<>();

    public City(String cityName, int location) {
        this.cityName = cityName;
        this.location = location;
        durationToCity.put(cityName, location);
    }
}
