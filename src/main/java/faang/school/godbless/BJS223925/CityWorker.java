package faang.school.godbless.BJS223925;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        Monster closestMonster = findClosestMonster();
        int timeToKillMonster = calculateTimeToKillMonster(closestMonster);
        int totalTime = calculateTotalTravelTime(timeToKillMonster);

        System.out.println("Геральт в городе " + city.getName() + " убивает монстра " + closestMonster.getName()
                + ". Общее время: " + totalTime + " минут.");
    }

    private Monster findClosestMonster() {
        Monster closestMonster = monsters.get(0);
        int closestDistance = Integer.MAX_VALUE;

        for (Monster monster : monsters) {
            int distance = calculateDistance(city.getDistances(), monster.getLocation());
            if (distance < closestDistance) {
                closestDistance = distance;
                closestMonster = monster;
            }
        }
        return closestMonster;
    }

    private int calculateDistance(int[] cityLocation, int[] monsterLocation) {
        int distance = 0;
        for (int i = 0; i < cityLocation.length; i++) {
            distance += Math.abs(cityLocation[i] - monsterLocation[i]);
        }
        return distance;
    }

    private int calculateTimeToKillMonster(Monster monster) {
        return monster.getName().length() * 8;
    }

    private int calculateTotalTravelTime(int timeToKillMonster) {
        int travelTime = 0;
        for (int distance : city.getDistances()) {
            travelTime += distance;
        }
        return travelTime + timeToKillMonster;
    }
}
