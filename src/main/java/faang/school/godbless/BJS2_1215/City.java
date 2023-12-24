package faang.school.godbless.BJS2_1215;

import lombok.Data;

@Data
public class City {
    private static City witcherCity;
    private String name;
    private Location location;
    private double distance;

    public City(String name, Location location) {
        if (witcherCity == null) {
            throw new IllegalStateException("Witcher city must be specified before creating other cities");
        }
        this.name = name;
        this.location = location;
        this.distance = calculateDistance(location);
    }

    private City(String name, Location location, double distance) {
        this.name = name;
        this.location = location;
        this.distance = distance;
    }

    public static City getWitcherCity() {
        return City.witcherCity;
    }

    public static void initializeWitcherCity(String name, Location location) {
        witcherCity = new City(name, location, 0);
    }

    public static double calculateDistance(Location location) {
        if (witcherCity == null) {
            throw new IllegalArgumentException("Witcher city must be specified");
        }
        return Additional.calculateDistance(location, witcherCity.location);
    }
}