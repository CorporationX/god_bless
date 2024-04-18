package faang.school.godbless.fingerpath;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CityWorker implements Runnable {

    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        System.out.println("Ближайшие монсты вблизи " + city.getName() + " - " + findNearestMonster().getName());
        System.out.println("Время на убийство: " + getKillTime() + " часов");
        System.out.println("Дистанция до города - " + getJourneyDistance());
    }

    public Monster findNearestMonster() {
        Location cityLocation = city.getLocation();
        Monster nearestMonster = null;
        int distance = Integer.MAX_VALUE;
        for (Monster monster : monsters) {
            Location monsterLocation = monster.getVillageLocation();

            int deltaSum = getDeltaSum(cityLocation, monsterLocation);
            if (deltaSum < distance) {
                distance = deltaSum;
                nearestMonster = monster;
            }
        }
        return nearestMonster;
    }

    public long getKillTime() {
        return (long) ((Math.random() + 1) * 5);
    }

    public long getJourneyDistance() {
        return city.getDistanceToHerald();
    }

    private int getDeltaSum(Location cityLocation, Location monsterLocation) {
        int deltaX = Math.abs(cityLocation.getX() - monsterLocation.getX());
        int deltaY = Math.abs(cityLocation.getY() - monsterLocation.getY());

        return deltaX + deltaY;
    }
}
