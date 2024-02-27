package faang.school.godbless.r_edzie.parallelism.witcher;

import java.util.List;
import java.util.Random;

public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;
    private Location currentLocation = new Location(0, 0);
    private Random random = new Random();

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        return monsters
                .stream()
                .min((monster1, monster2) ->
                        (int) (monster1.getLocation().distanceTo(city.getLocation()) - monster2.getLocation().distanceTo(city.getLocation())))
                .orElseThrow();
    }

    public long getKillTime() {
        return random.nextInt(1, 1000);
    }

    public long getJourneyDistance() {
        return (long) currentLocation.distanceTo(city.getLocation());
    }

    @Override
    public void run() {
        Monster nearestMonster = findNearestMonster(city, monsters);
        long journeyDistance = getJourneyDistance();
        long killTime = getKillTime();

        try {
            Thread.sleep(journeyDistance);
            Thread.sleep(killTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(city.getName());
        System.out.println(nearestMonster.getName());
        System.out.println(journeyDistance);
        System.out.println(killTime);

        System.out.println("----");

        currentLocation = city.getLocation();
    }
}
