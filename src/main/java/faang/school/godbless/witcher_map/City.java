package faang.school.godbless.witcher_map;

import lombok.Getter;

@Getter
public class City {

    private String name;
    private Location location;




    public City(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public void setDistance(City city, int distance) {
        distances.put(city, distance);
    }

    public int getDistanceTo(City city) {
        return distances.getOrDefault(city, -1);
    }
}
