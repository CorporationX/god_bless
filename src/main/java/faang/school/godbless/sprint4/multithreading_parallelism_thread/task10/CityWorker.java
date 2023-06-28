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
        Location locationCity = city.getLocation();

        for (int i = 0; i < monsters.size(); i++) {
            Location locationMonster = getLocationCoordinates(monsters.get(i).getLocation());
            if (minDuration > calculateDuration(locationCity, locationMonster)) {
                minDuration = calculateDuration(locationCity, locationMonster);
                nearestMonster = monsters.get(i);
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

    private Location getLocationCoordinates(String location) {
        switch (location) {
            case "Velen" -> {
                return new Location(10, 20);
            }
            case "Toussaint" -> {
                return new Location(40, 50);
            }
            case "White Orchard" -> {
                return new Location(100, 10);
            }
            case "Skellige" -> {
                return new Location(80, 120);
            }
            default -> {
                return new Location(0, 0);
            }
        }
    }

    private int calculateDuration(Location start, Location end) {
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        return x + y;
    }
}
