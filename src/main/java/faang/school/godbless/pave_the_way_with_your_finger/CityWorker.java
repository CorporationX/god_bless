package faang.school.godbless.pave_the_way_with_your_finger;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        System.out.println("Nearest monster to city " + city.getName() + " is " + findNearestMonster().getName());
        System.out.println("Time to kill it: " + getKillTime() + " hours");
        System.out.println("Distance to the city: " + getJourneyDistance());
    }

    public Monster findNearestMonster() {
        Location cityLocation = city.getCityLocation();
        Monster nearestMonster = null;
        double distance = Double.MAX_VALUE;
        for (Monster monster : monsters) {
            Location monsterLocation = monster.getLocationCoordinates(monster.getMonsterLocation());
            double delta = getDelta(cityLocation, monsterLocation);
            if (delta < distance) {
                distance = delta;
                nearestMonster = monster;
            }
        }
        return nearestMonster;
    }

    private static double getDelta(Location cityLocation, Location monsterLocation) {
        return Math.sqrt((cityLocation.getX() - monsterLocation.getX()) * (cityLocation.getX() - monsterLocation.getX())
                        + (cityLocation.getY() - monsterLocation.getY()) * (cityLocation.getY() - monsterLocation.getY()));
    }

    public long getKillTime() {
        return (long) ((Math.random() + 1) * 10);
    }

    public long getJourneyDistance() {
        return city.getDistance();
    }
}
