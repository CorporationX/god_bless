package faang.school.godbless.multithreadingS4.layPathWithYourFinger;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private static final int COEF_SLEEP = 250;
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        Monster nearestMonster = findNearestMonster();
        double distance = getJourneyDistance(nearestMonster);
        int timeToKill = getKillTime(nearestMonster);

        System.out.printf("%nThread - %s is running.%n" +
                        "Nearest monsters to %s: %s%n" +
                        "Kill time: %d%n" +
                        "Distance: %f%n",
                threadName,
                city.getName(),
                nearestMonster.getName(),
                timeToKill,
                distance);

        try {
            Thread.sleep((int) (distance + timeToKill) * COEF_SLEEP);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("\tThread - %s is finished.%n", threadName);
    }

    private Monster findNearestMonster() {
        Monster nearestMonster = monsters.get(0);
        double minDistance = getJourneyDistance(nearestMonster);

        for (int i = 1; i < monsters.size(); i++) {
            Monster currentMonster = monsters.get(i);
            double currentDistance = getJourneyDistance(currentMonster);
            if (currentDistance < minDistance) {
                minDistance = currentDistance;
                nearestMonster = currentMonster;
            }
        }
        return nearestMonster;
    }

    private int getKillTime(Monster monster) {
        return monster.getName().length() * 10;
    }

    private double getJourneyDistance(Monster monster) {
        int deltaX = city.getLocation().x() - monster.getLocation().y();
        int deltaY = city.getLocation().y() - monster.getLocation().y();
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

}
