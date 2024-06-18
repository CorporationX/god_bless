package faang.school.godbless.FingerYourWay;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {
    private static final int COUNT_THREAD = 3;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREAD);

        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", new Location(20, 60)));
        monsters.add(new Monster("Basilisk", new Location(110, 40)));
        monsters.add(new Monster("Cockatrice", new Location(50, 60)));
        monsters.add(new Monster("Chort", new Location(70, 10)));


        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60),  180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        for (City city : cities) {
            executorService.submit(() -> new CityWorker(city, monsters).run());
        }
        executorService.shutdown();
    }
}
