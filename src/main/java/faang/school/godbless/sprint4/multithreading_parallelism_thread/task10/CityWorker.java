package faang.school.godbless.sprint4.multithreading_parallelism_thread.task10;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class CityWorker implements Runnable {

    private List<Monster> monsters;

    private City city;

    @Override
    public void run() {
        Monster nearestMonster = searchNearestMonster();
        System.out.println("Ближайший монстр : от города " + city.getCityName() + " " + nearestMonster);
        System.out.println("TTK: " + timingToKillMonster());
        System.out.println("Общее время путешествия: " + totalTravelTime());
    }

    private Monster searchNearestMonster() {
        int minDuration = Integer.MAX_VALUE;
        Monster nearestMonster = null;
        int coordinateCity = 0;
        int coordinateMonster = 0;
        for (var entry : City.durationToCity.entrySet()) {
            if (city.getCityName().equals(entry.getKey())) {
                coordinateCity = entry.getValue();
                System.out.println(entry.getKey() + " координата города: " + coordinateCity);
                break;
            }
        }
        for (Monster monster : monsters) {
            coordinateMonster = monster.getLocation();
            if (Math.abs(coordinateCity - coordinateMonster) < minDuration) {
                minDuration = coordinateMonster;
                nearestMonster = monster;
            }
        }
        return nearestMonster;
    }

    private long timingToKillMonster() {
        return calculateRandomTime();
    }

    private long totalTravelTime() {
        return calculateRandomTime();
    }

    private long calculateRandomTime() {
        long start = System.currentTimeMillis();
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();

        return end - start;
    }
}
