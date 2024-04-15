package faang.school.godbless.FingerPath;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class CityWorker implements Runnable {
    private final City city;
    private final List<Monster> monsters;

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    public Monster findNearestMonster(Location location, List<Monster> monsters) {
        return monsters.stream()
                .min(Comparator.comparing(mon -> getDistance(mon.getLocation(), location)))
                .orElseThrow(() -> new RuntimeException("Monsters list is empty"));
    }

    public long getJourneyDistance(Location target) {
        return (long) (getDistance(city.getLocation(), target));
    }

    public long getKillingTime() {
        return new Random().nextInt(1000, 2000);
    }

    private double getDistance(Location first, Location second) {
        return Math.sqrt(Math.pow(first.getX() - second.getX(), 2) + Math.pow(first.getY() - second.getY(), 2));
    }

    @Override
    public void run() {
        try {
            Monster monster = findNearestMonster(city.getLocation(), monsters);
            System.out.println("Nearest monster to the city " + city.getName() + " --> " + monster.getName());

            Thread.sleep(getJourneyDistance(monster.getLocation()));
            System.out.println("Fight with " + monster.getName() + " starts");

            Thread.sleep(getKillingTime());
            System.out.println(monster.getName() + " was defeated");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
