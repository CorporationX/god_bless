package faang.school.godbless.witcher_map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
public class City {
    private String name;
    private Location location;
    private int distance;

    public City(String name){
        this.name = name;
    }
    public City(String name, Location location, int distance){
        this.name = name;
        this.location = location;
        this.distance = distance;
    }
}
