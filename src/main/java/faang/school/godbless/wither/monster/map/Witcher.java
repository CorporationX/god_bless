package faang.school.godbless.wither.monster.map;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class Witcher {
    private static final int ALL_ROUTE_CALCULATIONS_IN_SECONDS = 5;
    private static final int THREADS_NUMBER = 4;
    private static final City KAER_MORHEN = new City("Kaer Morhen", new Location(180, 70));
    private Location location;

    public Witcher() {
        this.location = KAER_MORHEN.getLocation();
    }

    public static void main(String[] args) {
        Witcher herald = new Witcher();

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_NUMBER);

        long start = System.currentTimeMillis();
        getCities().stream()
                .map(city -> new CityWorker(city, herald))
                .forEach(executorService::execute);
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(ALL_ROUTE_CALCULATIONS_IN_SECONDS, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
        long end = System.currentTimeMillis();

        System.out.printf("All time: %d", end - start);
    }

    public static List<Monster> getMonsters() {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockatrice", "White Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));
        return monsters;
    }

    private static List<City> getCities() {
        List<City> cities = new ArrayList<>();
        cities.add(KAER_MORHEN);
        cities.add(new City("Novigrad", new Location(0, 60)));
        cities.add(new City("Oxenfurt", new Location(60, 0)));
        cities.add(new City("Vizima", new Location(120, 50)));
        return cities;
    }
}
