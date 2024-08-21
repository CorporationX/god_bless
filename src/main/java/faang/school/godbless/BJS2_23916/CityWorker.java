package faang.school.godbless.BJS2_23916;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class CityWorker implements Runnable{
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        System.out.println("Nearest monster to city " + city.getName() + " is " + findNearestMonster().getName());
        System.out.println("Time to kill " + getKillTime());
        System.out.println("Distance to the city " + getJourneyDistance());
    }

    public Monster findNearestMonster() {
        Monster nearest = null;
        double minDistance = Integer.MAX_VALUE;

        for (Monster monster : monsters) {
            double distance = Math.sqrt(
                    Math.pow(monster.getLocationCoordinates(monster.getVillageLocation()).getX() - city.getLocation().getX(), 2) +
                            Math.pow(monster.getLocationCoordinates(monster.getVillageLocation()).getY() - city.getLocation().getY(), 2)
            );
            if (distance < minDistance) {
                minDistance = distance;
                nearest = monster;
            }
        }

        return nearest;
    }

    public long getKillTime(){
        long sleep = new Random().nextLong(1000, 5000);
        return sleep;
    }

    public long getJourneyDistance() {
        return 1L;
    }
}
