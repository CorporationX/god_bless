package faang.school.godbless.modul3.witcher;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;
    public static final long MAX_KILL_TIME = 6000L;
    public static final long MIN_KILL_TIME = 1000L;

    @Override
    public void run() {
        try {
            var monster = findNearestMonster(city, monsters);
            System.out.println("Target monster: " + monster.getName() + ", located in " + monster.getLocation());
            System.out.println("Witcher " + Thread.currentThread().getName() + " goes to " + monster.getLocation());
            Thread.sleep(getJourneyDistance(monster.getLocation()));

            System.out.println("Witcher " + Thread.currentThread().getName() + " fight with " + monster.getName());
            Thread.sleep(getTimeToKill());

            System.out.println("Witcher " + Thread.currentThread().getName() + " win");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        return monsters.stream()
                .min(Comparator.comparing(mob -> Math.abs(city.getLocation().getX() - mob.getLocation().getX())
                        + Math.abs(city.getLocation().getY() - mob.getLocation().getY())))
                .orElseThrow(RuntimeException::new);
    }

    public long getTimeToKill() {
        return new Random().nextLong(MIN_KILL_TIME, MAX_KILL_TIME);
    }

    public long getJourneyDistance(Location location) {
        return Math.abs(city.getLocation().getX() - location.getX())
                + Math.abs(city.getLocation().getY() - location.getY());
    }
}
