package TheWitcher;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;


    @Override
    public void run() {
        System.out.println("Ближайший монстры " + city.getName() +
                " - " + findNearestMonster(city, monsters).getName());
        System.out.println("Расчёт времени на убийство монстра " + getKillTime());
        System.out.println("Дальность путешествия " + getJourneyDistance());
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
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

    private int getDeltaSum(Location cityLocation, Location monsterLocation) {
        int deltaX = Math.abs(cityLocation.getX() - monsterLocation.getX());
        int deltaY = Math.abs(cityLocation.getY() - monsterLocation.getY());
        return deltaX + deltaY;
    }

    public long getKillTime() {
        return (long) ((Math.random() + 1) * 10);
    }

    public long getJourneyDistance() {
        return city.getDistance();
    }
}
