package faang.school.godbless.finger;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {

    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        System.out.println("Ближайший монсктр к городу " + city.getName() +
                " - " + findNearestMonster(city, monsters).getName());

        System.out.println("Время на убийство " + findNearestMonster(city, monsters).getName() +
                " = " + getKillTime());

        System.out.println("Расстояние до города " + city.getName() + " = " + getJourneyDistance());
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        Location cityLocation = city.getLocation();
        Monster nearestMonster = null;
        int distance = Integer.MAX_VALUE;

        for (Monster monster : monsters) {
            Location monsterLocation = monster.getLocation();

            int deltaX = Math.abs(cityLocation.getX() - monsterLocation.getX());
            int deltaY = Math.abs(cityLocation.getY() - monsterLocation.getY());

            int deltaSum = deltaX + deltaY;
            if (deltaSum < distance) {
                distance = deltaSum;
                nearestMonster = monster;
            }
        }

        return nearestMonster;
    }

    public long getKillTime() {
        return (long) ((Math.random() + 1) * 100);
    }

    public long getJourneyDistance() {
        return city.getDistance();
    }
}
