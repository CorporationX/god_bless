package faang.school.godbless.witcher_map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Witcher {

    public static void main(String[] args) {

        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", new Location("Velen",89,341),2));
        monsters.add(new Monster("Basilisk", new Location("Toussaint",12,15), 3));
        monsters.add(new Monster("Cockatrice", new Location("White Orchard", 234, -43),3));
        monsters.add(new Monster("Chort", new Location("Skellige",156, 123),5));

        List<City> cities = new ArrayList<>();
        cities.add(new City("Novigrad",new Location("Toussaint",12,15)));
        cities.add( new City("Oxenfurt", new Location("Skellige",156, 123)));
        cities.add(new City("Vizima",new Location("Velen",89,341)));
        cities.add(new City("Kaer Morhen",new Location("White Orchard", 234, -43)));



    }
}
