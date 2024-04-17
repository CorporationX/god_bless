package faang.school.godbless.PaveTheWayWithFinger;

import java.util.Comparator;
import java.util.List;

public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;
    private Monster nearestMonster;
    private long killTime;
    private long journeyDistance;

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    public Monster findMonster() {
        return monsters.stream()
                .filter(monster -> monster.getLocation() != null)
                .min(Comparator.comparingInt(monster ->
                        city.calculateDistanceToCity(new City(monster.getName(), monster.getLocation(), 0))
                ))
                .orElse(null);
    }

    public long getKillTime() {
        return (long) (Math.random() * 10) + 1;
    }

    public long getDistance() {
        journeyDistance = city.getDistanceFromWitcher();
        return journeyDistance;
    }

    @Override
    public void run() {

        nearestMonster = findMonster();
        System.out.println("Witcher is travels to " + city.getName() + " to kill " + nearestMonster.getName());
        long journeyTime = getDistance();
        System.out.println("Witcher goes " + journeyTime + " hours to reach " + city.getName());
        killTime = getKillTime();
        System.out.println("If Watcher is fights with the " + nearestMonster.getName() + ". This will take " + killTime + " hours.");
    }
}
