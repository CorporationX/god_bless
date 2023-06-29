package faang.school.godbless.fingerPath;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        List<Monster> monsters = getMonsters();
        List<City> cities = getCities();
        Location defaultLocation = new Location(180, 70);

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        long startTime = System.currentTimeMillis();

        for (City city : cities) {
            executor.execute(new CityWorker(city, monsters, defaultLocation));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + "ms");
    }

    private static List<Monster> getMonsters() {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockatrice", "White Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));

        return monsters;
    }

    private static List<City> getCities() {
        List<City> cities = new ArrayList<>();

        List<Integer> distances1 = new ArrayList<>();
        distances1.add(100);
        distances1.add(50);
        distances1.add(100);
        cities.add(new City("Novigrad", new Location(0, 60), distances1));

        List<Integer> distances2 = new ArrayList<>();
        distances2.add(70);
        distances2.add(60);
        distances2.add(110);
        cities.add(new City("Oxenfurt", new Location(60, 0), distances2));

        List<Integer> distances3 = new ArrayList<>();
        distances3.add(30);
        distances3.add(110);
        distances3.add(70);
        cities.add(new City("Vizima", new Location(120, 50), distances3));

        List<Integer> distances4 = new ArrayList<>();
        distances4.add(0);
        distances4.add(180);
        distances4.add(70);
        cities.add(new City("Kaer Morhen", new Location(180, 70), distances4));

        return cities;
    }

}
