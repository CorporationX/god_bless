package faang.school.godbless.bjs2_26016;

import java.util.List;

public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    @Override
    public void run() {
        int cityX = city.getLocation().getX();
        int cityY = city.getLocation().getY();

        double distanceToCity = calculateDistance(0, 0, cityX, cityY);
        double minDistanceToMonster = Double.MAX_VALUE;

        Monster monsterToKill = null;
        for (Monster m : monsters) {
            double distanceToMonster = calculateDistance(cityX, cityY, m.getLocation().getX(), m.getLocation().getY());
            if (distanceToMonster < minDistanceToMonster) {
                minDistanceToMonster = distanceToMonster;
                monsterToKill = m;
            }
        }

        double totalDistance = distanceToCity + minDistanceToMonster;
        System.out.println("Distance to monster " + monsterToKill.getName() + " = " + totalDistance);
    }

    public static double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x2 - x1) ^ 2 + (y2 - y1) ^ 2);
    }
}
