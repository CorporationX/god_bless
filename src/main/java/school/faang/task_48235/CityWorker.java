package school.faang.task_48235;

import lombok.Getter;

import java.util.List;

@Getter
public class CityWorker implements Runnable {
    private static final int CASTLE_X = 0;
    private static final int CASTLE_Y = 0;

    private City city;
    private final List<Monster> monsters;

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    @Override
    public void run() {
        int cityX = city.getLocation().getX();
        int cityY = city.getLocation().getY();

        double distanceCastleToCity = calculateDistance(CASTLE_X, CASTLE_Y, cityX, cityY);
        double distanceCityToNearestMonster = Integer.MAX_VALUE;

        for (Monster monster : monsters) {
            int monsterX = monster.getLocation().getX();
            int monsterY = monster.getLocation().getY();

            double minDist = calculateDistance(cityX, cityY, monsterX, monsterY);

            if (minDist < distanceCityToNearestMonster) {
                distanceCityToNearestMonster = minDist;
            }

            double totalDistance = distanceCastleToCity + distanceCityToNearestMonster;

            System.out.printf("Расстояние от замка до города: %s\n"
                            + "Расстояние от города до ближайшего монстра: %s\n"
                            + "Общее расстояние до монстра: %s\n",
                    distanceCastleToCity, distanceCityToNearestMonster, totalDistance);

        }
    }

    private static double calculateDistance(double x1, double y1, double x2, double y2) {
        double deltaX = x2 - x1;
        double deltaY = y2 - y1;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
