package faang.school.godbless.pathFinger;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private final static int NUMS_THREADS = 5;
    public static void main(String[] args) {
        Map<Monster, Long> monsterKillTime = getMonsterKillTime();
        List<Monster> monsters = monsterKillTime.keySet().stream().toList();
        List<CityWorker> listWorkers = getListWither(monsters, monsterKillTime);

        long before = System.currentTimeMillis();
        for(CityWorker works: listWorkers) {
            works.run();
        }
        long after = System.currentTimeMillis();
        System.out.println("Program execution time one thread: " + (after - before));

        ExecutorService executorService = Executors.newFixedThreadPool(NUMS_THREADS);
        long beforeThread = System.currentTimeMillis();
        for(CityWorker works: listWorkers) {
            executorService.submit(works);
        }
        executorService.shutdown();
        long afterThread = System.currentTimeMillis();
        System.out.println("Program execution time some thread: " + (afterThread - beforeThread));
    }

    private static Map<Monster, Long> getMonsterKillTime() {
        return Map.of(
                new Monster("type1", new Location(34, 7)), 500L,
                new Monster("type2", new Location(53, 2)), 300L,
                new Monster("type3", new Location(86, 15)), 100L,
                new Monster("type4", new Location(67, 85)), 800L,
                new Monster("type5", new Location(34, 53)), 3400L,
                new Monster("type6", new Location(34, 34)), 600L,
                new Monster("type7", new Location(86, 82)), 200L,
                new Monster("type8", new Location(75, 14)), 6500L,
                new Monster("type9", new Location(23, 0)), 900L,
                new Monster("type10", new Location(46, 95)), 200L
        );
    }

    private static List<CityWorker> getListWither(List<Monster> monsters, Map<Monster, Long> monsterKillTime) {
        return List.of(
                new CityWorker(monsters, new Witcher("wither1", 5), new City("town1", new Location(63, 74), monsterKillTime)),
                new CityWorker(monsters, new Witcher("wither2", 5), new City("town2", new Location(97, 45), monsterKillTime)),
                new CityWorker(monsters, new Witcher("wither3", 5), new City("town3", new Location(87, 23), monsterKillTime)),
                new CityWorker(monsters, new Witcher("wither4", 5), new City("town4", new Location(64, 87), monsterKillTime)),
                new CityWorker(monsters, new Witcher("wither5", 5), new City("town5", new Location(34, 98), monsterKillTime))
        );
    }
}
