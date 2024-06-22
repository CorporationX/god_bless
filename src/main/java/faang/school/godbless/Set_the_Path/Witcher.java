package faang.school.godbless.Set_the_Path;

import java.util.ArrayList;
import java.util.List;

public class Witcher {

    private static final List<Monster> MONSTERS = new ArrayList<>();
    private static final List<City> CITIES = new ArrayList<>();

    public static void main(String[] args) {






    }

    static {

        MONSTERS.add(new Monster("Griffin", "Velen"));
        MONSTERS.add(new Monster("Basilisk", "Toussaint"));
        MONSTERS.add(new Monster("Cockatrice", "White Orchard"));
        MONSTERS.add(new Monster("Chort", "Skellige"));

        CITIES.add(new City("Novigrad", new Location(0, 60),  180));
        CITIES.add(new City("Oxenfurt", new Location(60, 0), 70));
        CITIES.add(new City("Vizima", new Location(120, 50), 30));
        CITIES.add(new City("Kaer Morhen", new Location(180, 70), 0));

    }

}
