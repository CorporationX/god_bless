package school.faang.task_48235;

import lombok.Getter;

import java.util.List;
import java.util.Optional;

@Getter
public class CityWorker implements Runnable {
    private static final int CASTLE_X = 0;
    private static final int CASTLE_Y = 0;

    private final City city;
    private final List<Monster> monsters;

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    @Override
    public void run() {
        Optional<Integer> cityX = Optional.ofNullable(city.location().coordinateX());
        Optional<Integer> cityY = Optional.ofNullable(city.location().coordinateY());

        double distanceCastleToCity = calculateDistance(CASTLE_X, CASTLE_Y, cityX.orElse(0), cityY.orElse(0));
        double distanceCityToNearestMonster = Integer.MAX_VALUE;

        for (Monster monster : monsters) {
            double monsterX = monster.location().coordinateX();
            double monsterY = monster.location().coordinateY();

            double minDist = calculateDistance(cityX.orElse(0), cityY.orElse(0), monsterX, monsterY);

            if (minDist < distanceCityToNearestMonster) {
                distanceCityToNearestMonster = minDist;
            }

            double totalDistance = distanceCastleToCity + distanceCityToNearestMonster;

            System.out.printf("""
                            \nРасстояние от замка до города: %s"
                            Расстояние от города до ближайшего монстра: %s"
                            Общее расстояние до монстра: %s\n""",
                    distanceCastleToCity, distanceCityToNearestMonster, totalDistance);

        }
    }

    private static double calculateDistance(double x1, double y1, double x2, double y2) {
        double deltaX = x2 - x1;
        double deltaY = y2 - y1;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
