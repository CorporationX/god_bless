package school.faang.witcher;

public class City {
    private String name;
    private Location location;

    public City(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }
}
