package finger_way;

import java.util.ArrayList;
import java.util.List;

import static java.awt.AWTEventMulticaster.add;

public class Witcher {
    public static void main(String[] args) {
                        List<Monster> monsters = getMonsters();

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        public static List<Monster> getMonsters (){
        List<Monster> monsters = List.of(
                add(new Monster("Griffin", "Velen")),
                add(new Monster("Basilisk", "Toussaint")),
                add(new Monster("Cockatrice", "White Orchard")),
                add(new Monster("Chort", "Skellige")));
        return monsters;
    }

    }
}
