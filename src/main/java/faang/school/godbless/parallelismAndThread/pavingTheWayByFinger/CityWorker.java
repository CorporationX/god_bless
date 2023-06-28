package faang.school.godbless.parallelismAndThread.pavingTheWayByFinger;

import lombok.Getter;
import lombok.Setter;


@Getter
public class CityWorker implements Runnable {
    @Setter
    private City city;
    @Setter
    private Monster monster;
    private int totalTime;

    public CityWorker(City city, Monster monster) {
        this.city = city;
        this.monster = monster;
    }

    @Override
    public void run() {
        int distance = findClosestMonsterTime();
        int timeTiKill = calculateTimeToKillMonster();
        this.totalTime = calculateTotalTime(distance, timeTiKill);
    }

    private int findClosestMonsterTime() {
        if (!city.getDistances().containsKey(monster.getLocation())) {
            System.out.println("Монстр " + monster + " вне зоны досягаемости!");
            return Integer.MAX_VALUE;
        }

        return city.getDistances().get(monster.getLocation());
    }

    private int calculateTimeToKillMonster() {
        if (monster.getName().length() < 6) {
            return 10;
        } else if (monster.getName().length() >= 6 && monster.getName().length() <= 8) {
            return 15;
        } else {
            return 20;
        }
    }

    private int calculateTotalTime(int distance, int timeToKill) {
        return distance * 2 + timeToKill;
    }
}
