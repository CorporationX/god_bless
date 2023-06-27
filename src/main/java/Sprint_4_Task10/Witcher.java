package Sprint_4_Task10;

import java.util.ArrayList;
import java.util.List;

public class Witcher {
    public static void main(String[] args) {

        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockatrice", "White Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));



        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", 0, 60, 120, 180));
        cities.add(new City("Oxenfurt", 60, 0, 50, 70));
        cities.add(new City("Vizima", 120, 50, 0, 30));
        cities.add(new City("Kaer Morhen", 180, 70, 30, 0));
    }
}
