package faang.school.godbless.parallelism.witcher;

import java.util.List;

public class CityWorker implements Runnable {
    private final City city;
    private final List<Monster> monsters;


    public CityWorker(City city, List<Monster> monsters) {
        if (monsters.isEmpty() || city == null) {
            throw new IllegalArgumentException("Monster list is empty or  city is null");
        }
        this.city = city;
        this.monsters = monsters;
    }

    public Monster findNearestMonster() {
        Monster nearestMonster = null;
        long distance;
        long minDistance = Long.MAX_VALUE;
        for (Monster monster : this.monsters) {
            distance = getMonsterDistance(monster, this.city);
            if (distance < minDistance) {
                minDistance = distance;
                nearestMonster = monster;
            }
        }
        return nearestMonster;
    }

    public long getKillTime() {
        return (long) ((Math.random()+1)* findNearestMonster().getHealth());
    }

    public long getJourneyDistance() {
        return city.distance();
    }

    @Override
    public void run() {
        System.out.println(String.format("City %s nearest monster %s in region location: %s",
                this.city.cityName(), this.findNearestMonster().getMonsterName(), this.findNearestMonster().getRegionLocation()));
        System.out.println(String.format("Journey distance: %d kilometers", this.getJourneyDistance()));
        System.out.println(String.format("Kill time: %d minutes", this.getKillTime()));
    }

    private long getMonsterDistance(Monster monster, City city) {
        int deltaX = Math.abs(city.location().x() - monster.getLocation().x());
        int deltaY = Math.abs(city.location().y() - monster.getLocation().y());
        return (long) Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
