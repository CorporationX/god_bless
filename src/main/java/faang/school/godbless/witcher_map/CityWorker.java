package faang.school.godbless.witcher_map;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CityWorker implements Runnable {

    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        Monster nearestMonster = findNearestMonster();
        int travelTime = calculateTravelTime(nearestMonster);
        int killTime = calculateKillTime(nearestMonster);
        int totalTime = travelTime + killTime;

        System.out.println("City: " + city.getName());
        System.out.println("Nearest Monster: " + nearestMonster.getName());
        System.out.println("Travel Time: " + travelTime + " minutes");
        System.out.println("Kill Time: " + killTime + " minutes");
        System.out.println("Total Time: " + totalTime + " minutes");
        System.out.println();
    }

    private Monster findNearestMonster() {
        Monster nearestMonster = null;
        int shortestDistance = Integer.MAX_VALUE;

        for (Monster monster : monsters) {
            int distance = getDistanceToMonster(monster);
            if (distance < shortestDistance) {
                shortestDistance = distance;
                nearestMonster = monster;
            }
        }

        return nearestMonster;
    }

    private int getDistanceToMonster(Monster monster) {

    }

    private int calculateTravelTime(Monster monster) {
        return getDistanceToMonster(monster) * 10;
    }

    private int calculateKillTime(Monster monster) {
        return monster.getPower() * 5;
    }
}
