package faang.school.godbless.Set_the_Path;

import lombok.Getter;

@Getter
public class City {

    private String name;
    private Location location;
    private double distFromMage;

    public City(String name, Location location, double distance) {
        if (name.isBlank()) throw new IllegalArgumentException("name is blank");
        else {
            this.name = name;
            this.location = location;
            this.distFromMage = distance;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
