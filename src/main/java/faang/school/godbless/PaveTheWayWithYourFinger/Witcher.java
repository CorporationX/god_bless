package faang.school.godbless.PaveTheWayWithYourFinger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Witcher {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        ExecutorService execute = Executors.newFixedThreadPool(NUM_THREADS);

        List<Monster> monsters = getMonsters();
        List<City> cities = getCities();
        List<Area> areas = getAreas();

        long startTime = System.currentTimeMillis();

        cities.forEach(
                (city) -> execute.submit(new CityWorker(city, monsters, areas, getCurrentWitcherLocation(cities)))
        );

        execute.shutdown();
        try {
            execute.awaitTermination(20, SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long endTime = System.currentTimeMillis();;
        long totalTime = endTime - startTime;

        System.out.println(totalTime);
    }

    private static List<Monster> getMonsters() {
        return List.of(
                new Monster("Griffin", "Velen"),
                new Monster("Basilisk", "Toussaint"),
                new Monster("Cockatrice", "White Orchard"),
                new Monster("Chort", "Skellige")
        );
    }

    private static List<City> getCities() {
        return List.of(
                new City("Novigrad", new Location(0, 40), 124),
                new City("Oxenfurt", new Location(60, 0), 92),
                new City("Vizima", new Location(120, -90), 160),
                new City("Kaer Morhen", new Location(120, 70), 0)
        );
    }

    private static List<Area> getAreas() {
        return List.of(
                new Area("Velen", new Location(60, -60)),
                new Area("Toussaint", new Location(200, -200)),
                new Area("White Orchard", new Location(100, -150)),
                new Area("Skellige", new Location(-100, -70))
        );
    }

    public static Location getCurrentWitcherLocation(List<City> cities) {
        Location currentWitcherLocation = new Location(0, 0);
        for (City city : cities) {
            if (city.getDistanceToWitcher() == 0) {
                currentWitcherLocation = city.getLocation();
            }
        }
        return currentWitcherLocation;
    }
}
