package faang.school.godbless.BJS2_23884;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        Thread.currentThread().setName(city.getName() + "_thread");
        System.out.println("Nearest monster to city " + city.getName() + " is " + findNearestMonster(city, monsters).getName());
        System.out.println("Time to kill monster: " + getKillTime());
        System.out.println("Distance to the " + city.getName() + " is " + getJourneyDistance());
        System.out.println(Thread.currentThread().getName() + " is stopped");
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        Monster resultMonster = null;
        int minMonsterDist = Integer.MAX_VALUE;
        for (Monster monster : monsters) {
            int currMonsterDist = getMonsterDist(city, monster);
            if (currMonsterDist < minMonsterDist) {
                minMonsterDist = currMonsterDist;
                resultMonster = monster;
            }
        }
        return resultMonster;
    }

    private static int getMonsterDist(City city, Monster monster) {
        int diffX = Math.abs(city.getLocation().getCoordinateX() - monster.getCoordinates().getCoordinateX());
        int diffY = Math.abs(city.getLocation().getCoordinateY() - monster.getCoordinates().getCoordinateY());
        return diffX + diffY;
    }

    public long getKillTime() {
        return new Random().nextLong(1000, 10000);
    }

    public long getJourneyDistance() {
        return city.getPathToGeralt();
    }
}
