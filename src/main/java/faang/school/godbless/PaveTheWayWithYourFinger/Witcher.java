package faang.school.godbless.PaveTheWayWithYourFinger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Witcher {
    private static final List<Monster> monsters = new ArrayList<>();
    private static final List<City> cities = new ArrayList<>();
    private static final List<Area> areas = new ArrayList<>();
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        ExecutorService execute = Executors.newFixedThreadPool(NUM_THREADS);

        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockatrice", "White Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));

        cities.add(new City("Novigrad", new Location(0, 40), 124));
        cities.add(new City("Oxenfurt", new Location(60, 0), 92));
        cities.add(new City("Vizima", new Location(120, -90), 160));
        cities.add(new City("Kaer Morhen", new Location(120, 70), 0));

        areas.add(new Area("Velen", new Location(60, -60)));
        areas.add(new Area("Toussaint", new Location(200, -200)));
        areas.add(new Area("White Orchard", new Location(100, -150)));
        areas.add(new Area("Skellige", new Location(-100, -70)));

        for (City city : cities) {
            execute.submit(new CityWorker(city, monsters, areas, getCurrentWitcherLocation()));
        }
        try {
            execute.awaitTermination(4, SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        execute.shutdown();
    }

    public static Location getCurrentWitcherLocation() {
        Location currentWitcherLocation = new Location(0, 0);
        for (City city : cities) {
            if (city.getDistanceToWitcher() == 0) {
                currentWitcherLocation = city.getLocation();
            }
        }
        return currentWitcherLocation;
    }
}
