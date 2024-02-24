package faang.school.godbless.priscillasong2904;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class City {
    private final String name;
    private final Location location;
    private long distance;
    private static final List<City> CITIES_LIST = createCities();

    public City(String name, Location location, long distance) {
        this.name = name;
        this.location = location;
        this.distance = distance;
    }

    public static List<City> getCitiesList() {
        return CITIES_LIST;
    }

    private static List<City> createCities() {
        return new ArrayList<>(List.of(
                new City("Velen", new Location(0, 60), 180L),
                new City("Toussaint", new Location(60, 0), 70L),
                new City("White Orchard", new Location(120, 50), 30L),
                new City("Kaer Morhen", new Location(180, 70), 0L)
        ));
    }
}
