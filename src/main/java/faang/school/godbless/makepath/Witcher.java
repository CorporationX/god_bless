package faang.school.godbless.makepath;

import java.util.ArrayList;
import java.util.List;

public class Witcher {
    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();
        CityWorker cityWorker = new CityWorker();
        cities.add(new City("Novigrad", new Location(0, 60),  180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", new Location(0, 60)));
        monsters.add(new Monster("Basilisk", new Location(60, 0)));
        monsters.add(new Monster("Cockatrice", new Location(120, 50)));
        monsters.add(new Monster("Chort", new Location(180, 70)));
        City exampleCity = new City("Novigrad", new Location(0, 60),180);
        cityWorker.findNearestMonster(exampleCity,monsters);



    }
}
