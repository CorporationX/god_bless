package school.faang.bjs2_81589;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    public static void main(String[] args) throws InterruptedException {
        long time = System.currentTimeMillis();
        List<City> cities = List.of(
                new City("A", new Location(5, 3)),
                new City("B", new Location(1, 2)),
                new City("C", new Location(3, 6)),
                new City("D", new Location(3, 7)),
                new City("E", new Location(10, 3)),
                new City("F", new Location(23, 6)),
                new City("G", new Location(15, 2)),
                new City("A1", new Location(5, 3)),
                new City("B1", new Location(1, 2)),
                new City("C1", new Location(3, 6)),
                new City("D1", new Location(3, 7)),
                new City("E1", new Location(10, 3)),
                new City("F1", new Location(23, 6)),
                new City("G1", new Location(15, 2)),
                new City("A2", new Location(5, 3)),
                new City("B2", new Location(1, 2)),
                new City("C2", new Location(3, 6)),
                new City("D2", new Location(3, 7)),
                new City("E2", new Location(10, 3)),
                new City("F2", new Location(23, 6)),
                new City("G2", new Location(15, 2))
        );

        List<Monster> monsters = List.of(
                new Monster("a", new Location(10, 40)),
                new Monster("b", new Location(15, 50)),
                new Monster("c", new Location(35, 96)),
                new Monster("d", new Location(15, 34)),
                new Monster("e", new Location(12, 3)),
                new Monster("f", new Location(0, 6)),
                new Monster("g", new Location(5, 2))
        );

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (City city : cities) {
            executor.submit(new CityWorker(city, monsters));
        }

        executor.shutdown();
        if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println("Не все задачи завершены");
        }

        time = System.currentTimeMillis() - time;
        System.out.printf("время выполнения программы: %s%n%n", time);
    }
}