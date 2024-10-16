package school.faang.FingerWay;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int THREADS_COUNT = 3;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        Monster monster1 = new Monster("Golem", new Location(15, 40));
        Monster monster2 = new Monster("Gryphon", new Location(6, 14));
        Monster monster3 = new Monster("Troll", new Location(25, 6));
        Monster monster4 = new Monster("Ghost", new Location(14, 25));
        Monster monster5 = new Monster("Dragon", new Location(34, 8));
        Monster monster6 = new Monster("Witch", new Location(8, 35));

        List<Monster> monsters1 = new ArrayList<>(List.of(monster1, monster2, monster3));
        List<Monster> monsters2 = new ArrayList<>(List.of(monster4, monster5, monster6));

        City city1 = new City("Novigrad", new Location(46, 82));
        City city2 = new City("Oxenfurt", new Location(76, 34));

        List<CityWorker> workers = new ArrayList<>(List.of(new CityWorker(city1, monsters1), new CityWorker(city2, monsters2)));

        ExecutorService service = Executors.newFixedThreadPool(THREADS_COUNT);

        workers.forEach(service::execute);

        service.shutdown();

        if (!service.awaitTermination(10, TimeUnit.SECONDS)){
            service.shutdownNow();
            System.out.println("Something went wrong.");
        }

        long end = System.currentTimeMillis();

        System.out.println("Time taken: " + (end - start) + " milliseconds");
    }

}
