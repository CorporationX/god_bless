package BJS2_23892_PathByFinger;

import java.util.ArrayList;
import java.util.List;

public class Witcher {
    public static void main(String[] args) {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", new Location(120, 50)));
        monsters.add(new Monster("Basilisk", new Location(120, 50)));
        monsters.add(new Monster("Cockatrice", new Location(120, 50)));
        monsters.add(new Monster("Chort", new Location(120, 50)));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));
    }
}
