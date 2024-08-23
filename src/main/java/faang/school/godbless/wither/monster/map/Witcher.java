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
    private Location location;

    public Witcher() {
        this.location = kaerMorhen.getLocation();
    }

    private static List<Monster> monsters = new ArrayList<>();
    private static List<City> cities = new ArrayList<>();
    private static City kaerMorhen = new City("Kaer Morhen", new Location(180, 70));

    static {
        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockatrice", "White Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));
    }

    static {
        cities.add(kaerMorhen);
        cities.add(new City("Novigrad", new Location(0, 60)));
        cities.add(new City("Oxenfurt", new Location(60, 0)));
        cities.add(new City("Vizima", new Location(120, 50)));
    }

    static {
        Monster.addPlaceLocation("Toussaint", new Location(10, 15));
        Monster.addPlaceLocation("White Orchard", new Location(140, 10));
        Monster.addPlaceLocation("Velen", new Location(200, 45));
        Monster.addPlaceLocation("Skellige", new Location(120, 85));
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public static void main(String[] args) {
        Witcher herald = new Witcher();

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_NUMBER);
        long start = System.currentTimeMillis();
        try {
            cities.stream()
                    .map(city -> new CityWorker(city, herald))
                    .forEach(executorService::execute);
        } finally {
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(ALL_ROUTE_CALCULATIONS_IN_SECONDS, TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
        long end = System.currentTimeMillis();
        System.out.printf("All time: %d", end - start);
    }
}
