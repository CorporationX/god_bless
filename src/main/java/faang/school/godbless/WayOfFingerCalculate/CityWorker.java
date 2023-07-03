package faang.school.godbless.WayOfFingerCalculate;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {

    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        System.out.println("Required time to journey is " + getTimeForJourney());

    }

    public Monster searchNearestMonster() {
        Monster findMonster = null;
        int minDistance = Integer.MAX_VALUE;
        for (Monster monster : monsters) {
            int distanceToTheMonster = city.getLocation() - city.getDistances().get(monster.getLocation());
            if (minDistance > distanceToTheMonster) {
                minDistance = distanceToTheMonster;
                findMonster = monster;
            }
        }
        if (findMonster == null) {
            throw new NullPointerException("All monsters is killed");
        }
        System.out.println("Monster is finded: " + findMonster);
        return findMonster;
    }

    public int getTimeForKillMonster() {
        return (int) (Math.random() * 20);
    }

    public int getTimeForJourney() {
        int timeToReachMonster = Math.abs((city.getLocation()) - city.getDistances().get(searchNearestMonster().getLocation()));
        return getTimeForKillMonster() + timeToReachMonster;
    }
}
