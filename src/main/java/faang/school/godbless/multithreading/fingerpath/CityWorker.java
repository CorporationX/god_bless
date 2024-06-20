package faang.school.godbless.multithreading.fingerpath;

import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.util.Comparator.comparingDouble;

public record CityWorker(City city, List<Monster> monsters) implements Runnable {

    @Override
    public void run() {
        System.out.printf("Monster-%s is the nearest to the city-%s\n", findNearestMonster(city, monsters).name(), city.name());
        System.out.printf("Time to kill monster is %.0f ms\n", getKillTime());
        System.out.printf("Distance to the city-%s is %.0f\n", city.name(), getJourneyDistance());
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        return monsters.stream()
                .min(comparingDouble(monster -> distanceBetweenTwoLocations(city.location(), monster.location())))
                .orElse(null);
    }

    private double distanceBetweenTwoLocations(Location locationCity, Location locationMonster) {
        return sqrt(
                pow(locationCity.x() - locationMonster.x(), 2) +
                        pow(locationCity.y() - locationMonster.y(), 2));
    }

    public double getKillTime() {
//        int sleepTime = ThreadLocalRandom.current().nextInt(100, 1000);
        int sleepTime = 500;
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return sleepTime;
    }

    public double getJourneyDistance() {
        return distanceBetweenTwoLocations(city.location(), new Location(0, 0));
    }
}
