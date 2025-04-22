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
        double xLocation = city.getLocation().getXVal();
        double yLocation = city.getLocation().getYVal();
        double distanceCastleToCity = Math.sqrt(xLocation * xLocation + yLocation * yLocation);

        double minDistanceToMonster = Integer.MAX_VALUE;
        Monster closestMonster = monsters.get(0);
        for (Monster monster : monsters) {
            double xToMonster = Math.abs(city.getLocation().getXVal() - monster.getLocation().getXVal());
            double yToMonster = Math.abs(city.getLocation().getYVal() - monster.getLocation().getYVal());
            double distanceCityToMonster = Math.sqrt(xToMonster * xToMonster + yToMonster * yToMonster);
            if (distanceCityToMonster < minDistanceToMonster) {
                minDistanceToMonster = distanceCityToMonster;
                closestMonster = monster;
            }
        }
        double distanceCastleToMonster = distanceCastleToCity + minDistanceToMonster;

        System.out.println(String.format("Расстояние от замка Ведьмака (координаты (0, 0)) до города %s - %.1f",
                city.getName(), distanceCastleToCity));
        System.out.println(String.format("Расстояние от города %s (координаты (%s, %s)) до ближайшего монстра - %.1f",
                city.getName(), city.getLocation().getXVal(), city.getLocation().getYVal(), minDistanceToMonster));
        System.out.println(String.format("Расстояние от замка до города плюс расстояние от города %s до ближайшего " +
                "монстра " + "составляет %.1f часов. " + "Выбранная цель %s", city.getName(),
                distanceCastleToMonster, closestMonster.getName()));
    }
}
