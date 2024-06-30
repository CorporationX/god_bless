package faang.school.godbless.BJS212222;

import lombok.Getter;

@Getter
public class City {
    private String name;
    private Location location;

    public City(String name, Location location) {
        this.name = name;
        this.location = location;
    }
}
