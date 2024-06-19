package faang.school.godbless.pave_the_way;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    private double getDistance(Location l1, Location l2) {
        double x2MinusX1 = l2.getX() - l1.getX();
        double y2MinusY1 = l2.getY() - l1.getY();
        return Math.sqrt(Math.pow(x2MinusX1, 2) + Math.pow(y2MinusY1, 2));
    }

    @Override
    public void run() {
        Monster monster = findNearestMonster();
        String nameOfCurrentThread = Thread.currentThread().getName();

        System.out.printf("%s: nearest monster detected: %s\n", nameOfCurrentThread, monster.getName());
        try {
            System.out.printf("%s: killing monster '%s'...\n", nameOfCurrentThread, monster.getName());
            Thread.sleep(getKillTime());
        } catch (InterruptedException e) {
            throw new RuntimeException(String.format("%s killing monster '%s' failed", nameOfCurrentThread, monster.getName()));
        }
        System.out.printf("%s: monster '%s' dead\n", nameOfCurrentThread, monster.getName());
    }

    public Monster findNearestMonster() {
        Monster nearest = null;
        double min = Double.MAX_VALUE;

        for (Monster monster : monsters) {
            double res = getDistance(monster.getLocation(), city.getLocation());
            if (res < min) {
                min = res;
                nearest = monster;
            }
        }

        return nearest;
    }

    public long getKillTime() {
        return new Random().nextInt(2000, 3000);
    }

    public long getJourneyDistance() {
        return city.getDistanceFromWitcher();
    }
}
