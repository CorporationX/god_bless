package school.faang.finger_point_way;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Getter
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        double xlocation = city.getLocation().getXxVal();
        double ylocation = city.getLocation().getYyVal();
        double distanceCastleToCity = Math.sqrt(xlocation * xlocation + ylocation * ylocation);

        double minDistanceToMonster = Integer.MAX_VALUE;
        Monster closestMonster = monsters.get(0);
        for (Monster monster : monsters) {
            double distanceCityToMonster = calculateDistanceBetween(city.getLocation(), monster.getLocation());
            if (distanceCityToMonster < minDistanceToMonster) {
                minDistanceToMonster = distanceCityToMonster;
                closestMonster = monster;
            }
        }
        double distanceCastleToMonster = distanceCastleToCity + minDistanceToMonster;

        System.out.println(String.format("Расстояние от замка Ведьмака (координаты (0, 0)) до города %s - %.1f",
                city.getName(), distanceCastleToCity));
        System.out.println(String.format("Расстояние от города %s (координаты (%s, %s)) до ближайшего монстра - %.1f",
                city.getName(), city.getLocation().getXxVal(), city.getLocation().getYyVal(), minDistanceToMonster));
        System.out.println(String.format("Расстояние от замка до города плюс расстояние от города %s до ближайшего " +
                        "монстра " + "составляет %.1f часов. " + "Выбранная цель %s", city.getName(),
                distanceCastleToMonster, closestMonster.getName()));
    }

    private double calculateDistanceBetween(Location location1, Location location2) {
        double xdistance = Math.abs(location1.getXxVal() - location2.getXxVal());
        double ydistance = Math.abs(location1.getYyVal() - location2.getYyVal());
        return Math.sqrt(xdistance * xdistance + ydistance * ydistance);
    }
}
