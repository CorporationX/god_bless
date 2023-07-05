package faang.school.godbless.task.fingerPath;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CityWorker implements Runnable {

    private City city;
    private List<Monster> monsters;

    public Monster findNearestMonster() {
        int threadPoolSize = Math.min(monsters.size(), 100);
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);

        Map<Monster, Future<Integer>> monsterFutureDistances = new HashMap<>();

        for (Monster monster : monsters) {
            monsterFutureDistances.put(
                    monster,
                    executorService.submit(
                            () -> getDistance(city.getLocation(), monster.getLocation())
                    )
            );
        }

        executorService.shutdown();

        return monsterFutureDistances.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        futureEntry -> {
                            try {
                                return futureEntry.getValue().get();
                            } catch (InterruptedException | ExecutionException e) {
                                throw new RuntimeException(e);
                            }
                        }
                ))
                .entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .get().getKey();
    }

    private static int getDistance(Location locationFrom, Location locationTo) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return Math.abs(locationFrom.getX() - locationTo.getX())
                + Math.abs(locationFrom.getY() - locationTo.getY());
    }

    public long getKillTime() {
        return new Random().nextInt(5, 24);
    }

    public long getJourneyDistance(Monster monster) {
        return city.getDistance() + monster.getLocation().getX() + monster.getLocation().getY();
    }

    @Override
    public void run() {
        Monster monster = findNearestMonster();
        System.out.println(monster.getName() + " is nearest monster for " + city.getName());
        System.out.println(monster.getName() + " was killed for " + getKillTime() + " hours");
        System.out.println("Journey distance to " + monster.getName() + " was " + getJourneyDistance(monster));
    }
}
