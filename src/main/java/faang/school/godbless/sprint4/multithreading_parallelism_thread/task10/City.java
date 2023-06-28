package faang.school.godbless.sprint4.multithreading_parallelism_thread.task10;

import lombok.Getter;

@Getter
public class City {

    private String cityName;

    private Location location;

    public City(String cityName, Location location) {
        this.cityName = cityName;
        this.location = location;
    }
}
