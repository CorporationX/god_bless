package faang.school.godbless.fingerpath;

import static faang.school.godbless.fingerpath.Witcher.heraldLocation;

public class City {

    private final String name;
    private final Location location;
    private final double distance;

    public City(String name, Location location) {
        this.name = name;
        this.location = location;
        this.distance = Location.calculateDistance(location, heraldLocation);
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public double getDistance() {
        return distance;
    }
}
