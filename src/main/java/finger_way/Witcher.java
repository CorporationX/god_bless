package finger_way;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Witcher {
    private static City novigrade = new City("Novigrad", new Location(0, 60), 180);
    private static City oxenfurt = new City("Oxenfurt", new Location(60, 0), 70);
    private static City vizima = new City("Vizima", new Location(120, 50), 30);
    private static City kaer_morhen = new City("Kaer Morhen", new Location(180, 70), 0);
    private static final int num_threads = 5;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Monster> monsters = getMonsters();
        List<City> cities = getCities();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        long start = System.currentTimeMillis();
        List<CompletableFuture<Void>> futures = cities.stream()
                .map(city -> CompletableFuture.runAsync(() -> new CityWorker(city, monsters).run()))
                .toList();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).get();
        executorService.shutdownNow();
        while (!executorService.awaitTermination(3, TimeUnit.SECONDS)){}
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static List<City> getCities() {
        return List.of(novigrade,oxenfurt,vizima,kaer_morhen);
    }

    private static List<Monster> getMonsters() {
        return List.of(
                new Monster("Basilisk", "Toussaint"),
                new Monster("Griffin", "Velen"),
                new Monster("Cockatrice", "White Orchard"),
                new Monster("Chort", "Skellige"));
    }
}
