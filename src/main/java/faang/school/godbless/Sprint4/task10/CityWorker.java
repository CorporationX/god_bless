package faang.school.godbless.Sprint4.task10;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;

    private List<Monster> monsters;

    public Monster findNearestMonster() {
        Location cityLocation = city.getLocation();
        Monster nearestMonster = null;
        int distance = Integer.MAX_VALUE;
        for (Monster monster : monsters) {
            Location monsterLocation = monster.getVillageLocation();

            int deltaSum = getDeltaSum(cityLocation, monsterLocation);
            if (deltaSum < distance) {
                nearestMonster = monster;
                distance = deltaSum;
            }
        }
        return nearestMonster;
    }

    private int getDeltaSum(Location cityLocation, Location monsterLocation) {
        int deltaX = Math.abs(cityLocation.getX() - monsterLocation.getX());
        int deltaY = Math.abs(cityLocation.getY() - monsterLocation.getY());
        return deltaX + deltaY;
    }

    public long getKillTime() {
        return (long) ((Math.random() + 1) * 10);
    }

    public long getJourneyDistance() {
        return city.getDistance();
    }

    @Override
    public void run() {
        System.out.println("Nearest monster to City " + city.getName() + " is " + findNearestMonster().getName());
        System.out.println("Time to kill monster is " + getKillTime());
        System.out.println("Journey distance is " + getJourneyDistance());
    }

}
