package BJS2_23892_PathByFinger;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {

    private City city;
    private List<Monster> monsters;

    public Monster findNearestMonster() {
        Location cityLocation = city.getLocation();
        Monster monsterToFind = null;
        double distance = Double.MAX_VALUE;
        for (Monster monster : monsters) {
            Location monsterLocation = monster.getVillageLocation();
            double x = Math.abs(cityLocation.getX() - monsterLocation.getX());
            double y = Math.abs(cityLocation.getY() - monsterLocation.getY());
            double deltaSum = x + y;
            if (deltaSum < distance) {
                distance = deltaSum;
                monsterToFind = monster;
            }
        }
        return monsterToFind;
    }

    public long getKillTime() {
        long startTime = System.currentTimeMillis();
        System.out.println("Starting battle with: " + findNearestMonster().getMonsterName());
        try {
            Thread.sleep((long) ((Math.random() + 1) * 3000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return (System.currentTimeMillis() / 1000) - (startTime / 1000);
    }

    public long getJourneyDistance(City city) {
        return city.getDistance();
    }

    @Override
    public void run() {
        System.out.println("Nearest monster to city " + city.getCityName() +
                " is " + findNearestMonster().getMonsterName());
        System.out.println("Time to kill " + findNearestMonster().getMonsterName() +
                " is: " + getKillTime() + " hours!");
        System.out.println("Distance to the city: " + getJourneyDistance(city));
    }
}
