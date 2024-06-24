package faang.school.godbless.multithreading.fingerpath;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int THREADS_NUMBER = 1;
    public static void main(String[] args) throws InterruptedException {
        List<Monster> monsters = List.of(
                new Monster("Griffin", new Location(35, 60)),
                new Monster("Basilisk", new Location(50, 160)),
                new Monster("Cockatrice", new Location(100, 60)),
                new Monster("Chort", new Location(20, 60)),
                new Monster("Drowner", new Location(25, 100)),
                new Monster("Nekker", new Location(40, 120)),
                new Monster("Leshen", new Location(60, 200)),
                new Monster("Fiend", new Location(80, 140)),
                new Monster("Werewolf", new Location(90, 150)),
                new Monster("Wraith", new Location(10, 180)),
                new Monster("Succubus", new Location(120, 110)),
                new Monster("Vampire", new Location(130, 80)),
                new Monster("Specter", new Location(140, 90)),
                new Monster("Golem", new Location(150, 70)),
                new Monster("Lamia", new Location(160, 60)),
                new Monster("Harpy", new Location(170, 50)),
                new Monster("Siren", new Location(180, 40)),
                new Monster("Djinn", new Location(190, 30)),
                new Monster("Striga", new Location(200, 20)),
                new Monster("Sylvan", new Location(210, 10))
        );

        List<City> cities = List.of(
                new City("Novigrad", new Location(0, 60), 180),
                new City("Oxenfurt", new Location(60, 0), 70),
                new City("Vizima", new Location(120, 50), 30),
                new City("Kaer Morhen", new Location(180, 70), 0),
                new City("Beauclair", new Location(50, 100), 150),
                new City("Toussaint", new Location(75, 120), 90),
                new City("Rivia", new Location(100, 140), 110),
                new City("Ard Skellig", new Location(25, 160), 60),
                new City("Skellige", new Location(85, 180), 50),
                new City("Cintra", new Location(65, 200), 100),
                new City("Verden", new Location(95, 80), 40),
                new City("Vergen", new Location(115, 90), 70),
                new City("Ban Ard", new Location(135, 100), 130),
                new City("Pont Vanis", new Location(155, 110), 60),
                new City("Maribor", new Location(175, 120), 80),
                new City("Gors Velen", new Location(195, 130), 90),
                new City("Brokilon", new Location(45, 140), 50),
                new City("Yennefer's Vineyard", new Location(65, 150), 30),
                new City("Druids' Grove", new Location(85, 160), 40),
                new City("Blaviken", new Location(105, 170), 20)
        );

        ExecutorService threadPool = Executors.newFixedThreadPool(THREADS_NUMBER);
        var startTime = System.currentTimeMillis();

        cities.forEach(city -> threadPool.submit(new CityWorker(city, monsters)));
        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.MINUTES);

        var endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + " ms");
    }
}
