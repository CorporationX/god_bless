package faang.school.godbless.multithreading.fingernavigator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();

        cities.add(new City("Eldora", new Location(15, 70),  105));
        cities.add(new City("Mirabela", new Location(85, 150), 60));
        cities.add(new City("Aetheria", new Location(25, 135), 125));
        cities.add(new City("Luminaria", new Location(40, 10), 145));
        cities.add(new City("Celestia", new Location(175, 60), 160));

        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Gorthok", cities.get(0), 28));
        monsters.add(new Monster("Valtor", cities.get(1), 18));
        monsters.add(new Monster("Khatos", cities.get(2), 32));
        monsters.add(new Monster("Tharros", cities.get(2), 22));
        monsters.add(new Monster("Xarath", cities.get(3), 38));

        CityWorker cityWorker = CityWorker.create(cities, monsters);

        cityWorker.start();
        cityWorker.start(1);
        cityWorker.start(2);
        cityWorker.start(3);
    }

}
