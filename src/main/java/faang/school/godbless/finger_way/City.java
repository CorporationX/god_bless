package faang.school.godbless.finger_way;

import lombok.Getter;

@Getter
public class City {
    private String title;
    private Location location;
    private Location distance;

    public City(String title, Location location, Location distance) {
        this.title = title;
        this.location = location;
        this.distance = distance;
    }
}
