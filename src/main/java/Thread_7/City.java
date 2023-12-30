package Thread_7;

public class City {

    private String name;
    private Location location;
    private int distance;

    public City(String name, Location location, int distance) {
        this.name = name;
        this.location = location;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public int getDistance() {
        return distance;
    }

}
