package faang.school.godbless.FingerYourWay;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {
    private static final int COUNT_THREAD = 3;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREAD);

        List<Monster> monsters = setMonsters();

        List<City> cities = setCities();

        for (City city : cities) {
            executorService.submit(new CityWorker(city, monsters));
        }
        executorService.shutdown();
    }

    private static List<Monster> setMonsters() {
        return List.of(
                new Monster("Griffin", new Location(20, 60)),
                new Monster("Basilisk", new Location(110, 40)),
                new Monster("Cockatrice", new Location(50, 60)),
                new Monster("Chort", new Location(70, 10)));
    }

    private static List<City> setCities() {
        return List.of(
                new City("Novigrad", new Location(0, 60), 180),
                new City("Oxenfurt", new Location(60, 0), 70),
                new City("Vizima", new Location(120, 50), 30),
                new City("Kaer Morhen", new Location(180, 70), 0));
    }
}
