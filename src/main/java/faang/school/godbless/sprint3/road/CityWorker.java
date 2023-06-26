package faang.school.godbless.sprint3.road;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters = new ArrayList<>();


    @Override
    public void run() {
        System.out.println("City " + city.getName());
        System.out.println("Nearest monster: " + findNearestMonster().getName() + ", distance: " + Math.abs(city.getLocation() - findNearestMonster().getLocation()));
        System.out.println("Time to kill monster: " + calculateTimeToKillMonster(findNearestMonster()));
        System.out.println("Total time: " + calculateTimeToKillMonster(findNearestMonster()) + calculateTravelTime(findNearestMonster()));
    }

    private Monster findNearestMonster() {
        Monster nearestMonster = monsters.get(0);
        assert city != null;
        int nearestDistance = Math.abs(city.getLocation() - nearestMonster.getLocation());

        for (Monster monster : monsters) {
            int distance = Math.abs(city.getLocation() - monster.getLocation());

            if (distance < nearestDistance) {
                nearestMonster = monster;
                nearestDistance = distance;
            }
        }

        return nearestMonster;
    }

    private int calculateTimeToKillMonster(Monster monster) {
        int distance = Math.abs(city.getLocation() - monster.getLocation());
        int time = distance / 5;
        return time;
    }

    private int calculateTravelTime(Monster monster) {
        int distance = city.getDistances().get(monster.getName());
        int time = distance / 10;
        return time;
    }
}
