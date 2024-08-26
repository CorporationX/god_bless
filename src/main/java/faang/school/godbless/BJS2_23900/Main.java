package faang.school.godbless.BJS2_23900;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Novigrad", new Location(0, 60),  180));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));

        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", cities.get(0), 12));
        monsters.add(new Monster("Basilisk", cities.get(1), 23));
        monsters.add(new Monster("Robert", cities.get(2), 40));
        monsters.add(new Monster("Cockatrice", cities.get(2), 32));
        monsters.add(new Monster("Chort", cities.get(3), 34));

        CityWorker cityWorker = CityWorker.create(cities, monsters);
        cityWorker.start(); // 36сек.
        cityWorker.start(1); // +1мин.
        cityWorker.start(2); // 36сек.
        cityWorker.start(3); // 36сек.
    }
}
