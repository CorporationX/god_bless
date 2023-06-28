package Lay_a_path;

import java.util.List;

public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    private Monster findTheNearestMonster() {
        Monster nearestMonster = null;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < monsters.size(); i++) {
            int distance = city.getDistance()[i];
            if (distance < minDistance) {
                minDistance = distance;
                nearestMonster = monsters.get(i);
            }
        }
        return nearestMonster;
    }

    private int calculateKillTime(Monster monster) {
        return monster.getName().length() + monster.getLocation().length();
    }

    private int calculateTravelTime() {
        int[] distances = city.getDistance();
        int travelTime = 0;
        for (int distance : distances) {
            travelTime += distance;
        }
        return travelTime;
    }

    @Override
    public void run() {
        Monster nearestMonster = findTheNearestMonster();
        int killTime = calculateKillTime(nearestMonster);
        int travelTime = calculateTravelTime();
        System.out.println("Nearest monster in city - " + city.getName() +
                " is " + nearestMonster.getName() + " (Kill time: " + killTime +
                " | Travel time: " + travelTime);
    }

}
