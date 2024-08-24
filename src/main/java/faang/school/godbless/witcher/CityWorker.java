package faang.school.godbless.witcher;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    private Monster findNearestMonster() {
        Location thisLocation = city.getLocation();
        double minDistance = Double.MAX_VALUE;
        Monster nearestMonster = null;
        for (Monster monster : monsters) {
            Location monterLocation = monster.getCity().getLocation();
            if (Location.distance(thisLocation, monterLocation) < minDistance) {
                minDistance = Location.distance(thisLocation, monterLocation);
                nearestMonster = monster;
            }
        }
        return nearestMonster;
    }

    private int getJourneyDistance() {
        return city.getDistanceFromWitcher();
    }

    private int killMonster(Monster monster) {
        try {
            Thread.sleep(monster.getKillTime());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return monster.getKillTime();
    }

    @Override
    public void run() {
        long totalTime = 0;

        int journeyDistance = getJourneyDistance();
        totalTime += journeyDistance;

        System.out.println("Witcher goes to " + city.getName());

        Monster nearestMonster = findNearestMonster();

        if (nearestMonster != null) {
            System.out.println("Nearest monster: " + nearestMonster.getName() + " is in the " + nearestMonster.getCity().getName());
            totalTime += killMonster(nearestMonster);
        }

        System.out.println("The witcher cleaned the " + city.getName() + " in " + totalTime + " milliseconds");
    }
}
