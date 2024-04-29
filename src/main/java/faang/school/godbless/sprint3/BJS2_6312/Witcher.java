package faang.school.godbless.sprint3.BJS2_6312;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int THREADS_COUNT = 4;
    private static final List<City> CITIES = new ArrayList<>(List.of(
            new City("Novigrad", new Location(0, 60),  180),
            new City("Oxenfurt", new Location(60, 0), 70),
            new City("Vizima", new Location(120, 50), 30),
            new City("Kaer Morhen", new Location(180, 70), 0)
    ));
    private static final List<Monster> MONSTERS = new ArrayList<>(List.of(
            new Monster("Griffin", "Velen"),
            new Monster("Basilisk", "Toussaint"),
            new Monster("Cockatrice", "Swamps"),
            new Monster("Chort", "Skellige")
    ));

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);

        long startTime = System.currentTimeMillis();

        for (City city : CITIES) {
            executorService.execute(() -> {
                CityWorker cityWorker = new CityWorker(city, MONSTERS);
                killMonster(cityWorker.findNearestMonster());
            });
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException exception) {
            System.out.println(exception);
            throw exception;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + "ms");
    }

    public static void killMonster(Monster monster) {
        int timeToKill = Monster.getTimeToKill(monster);

        System.out.println("The Witcher starts a fight with the monster");

        try {
            Thread.sleep(timeToKill);
        } catch (InterruptedException e) {
            System.out.println("It was interrupted during the fight");
            Thread.currentThread().interrupt();
        }

        System.out.println("The fight is over. The monster is killed:" + monster.getName());
    }
}
