package witcher;

public class City {
    private String name;
    private Location location;
    private double distanceToGeralt;

    public City(String name, Location location, double distanceToGeralt) {
        this.name = name;
        this.location = location;
        this.distanceToGeralt = distanceToGeralt;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }
}

