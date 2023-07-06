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
        String monsterName = nearestMonster.getName();

        System.out.println("City: " + city.getName());
        System.out.println("Nearest Monster: " + monsterName);
        System.out.println("Travel Time to the " + monsterName + " is: " + travelTime + " minutes");
        System.out.println("Time to kill the " + monsterName + " is: " + killTime + " minutes");
        System.out.println("Total time for reaching and killing the " + monsterName + " is: " + totalTime + " minutes");
    }

    private Monster findNearestMonster() {
        Monster nearestMonster = null;
        double shortestDistance = Integer.MAX_VALUE;

        for (Monster monster : monsters) {
            double distance = getDistanceToMonster(monster.getLocation());
            if (distance < shortestDistance) {
                shortestDistance = distance;
                nearestMonster = monster;
            }
        }

        return nearestMonster;
    }

    private double getDistanceToMonster(Location monsterLocation) {
        double baseLatitude = city.getLocation().getLatitude();
        double baseLongitude = city.getLocation().getLongitude();

        double latitudeDiff = Math.abs(monsterLocation.getLatitude() - baseLatitude);
        double longitudeDiff = Math.abs(monsterLocation.getLongitude() - baseLongitude);
        return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
    }

    private int calculateTravelTime(Monster monster) {
        return (int) getDistanceToMonster(monster.getLocation()) + 5;
    }

    private int calculateKillTime(Monster monster) {
        return monster.getPower() * 5;
    }
}
