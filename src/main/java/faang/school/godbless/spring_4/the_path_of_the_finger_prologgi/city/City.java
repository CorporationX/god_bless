package faang.school.godbless.spring_4.the_path_of_the_finger_prologgi.city;

public class City {
    private final String city;
    private final Location location;

    private final int distanceToTheCity;

    public City(String city, Location location, int distanceToTheCity) {
        this.city = city;
        this.location = location;
        this.distanceToTheCity = distanceToTheCity;
    }

    public int getDistanceToTheCity() {
        return distanceToTheCity;
    }

    public String getCity() {
        return city;
    }

    public Location getLocation() {
        return location;
    }
}
