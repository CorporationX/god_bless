package faang.school.godbless.BJS2_23910;

import java.util.List;


public class CityWorker implements Runnable {
    private static final int MAX_KILL_TIME = 100;
    private static final int MIN_KILL_TIME = 10;

    private final City city;
    private final List<Monster> monsters;

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Monster nearestMonster = findNearestMonster();
        System.out.println("Геральт прибыл в " + city.getName() +
                " и убивает " + nearestMonster.getName() +
                ". Дистанция до города " + getDistance() +
                " минут, убийство заняло " + getKillTime() + " минут.");
    }

    public Monster findNearestMonster() {
        Location cityLocation = city.getLocation();

        return monsters.stream()
                .min((m1, m2) -> Integer.compare(
                        getDeltaSum(cityLocation, m1.getVillageLocation()),
                        getDeltaSum(cityLocation, m2.getVillageLocation())))
                .orElseThrow();
    }

    public long getKillTime() {
        return (long) ((Math.random() * (MAX_KILL_TIME - MIN_KILL_TIME + 1)) + MIN_KILL_TIME);
    }

    public long getDistance() {
        return city.getDistance();
    }

    private int getDeltaSum(Location cityLocation, Location monsterLocation) {
        int deltaX = Math.abs(cityLocation.getX() - monsterLocation.getX());
        int deltaY = Math.abs(cityLocation.getY() - monsterLocation.getY());
        return deltaX + deltaY;
    }
}
