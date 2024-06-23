package faang.school.godbless.paveTheWay;

public class City {
    private String name;
    private Location location;
    private double distanceFromWitcher;

    public City(String name, Location location, double distanceFromWitcher) {
        this.name = name;
        this.location = location;
        this.distanceFromWitcher = distanceFromWitcher;
    }

    public String getName(){
        return name;
    }

    public Location getLocation(){
        return location;
    }

    public double getDistanceFromWitcher() {
        return distanceFromWitcher;
    }
}
