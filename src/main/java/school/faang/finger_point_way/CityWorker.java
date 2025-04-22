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
        double xCity = city.getLocation().getX();
        double yCity = city.getLocation().getY();
        double distanceCastleToCity = Math.sqrt(xCity * xCity + yCity * yCity);

        double minDistanceToMonster = Integer.MAX_VALUE;
        Monster closestMonster = monsters.get(0);
        for (Monster monster : monsters) {
            double xCityToMonster = Math.abs(city.getLocation().getX() - monster.getLocation().getX());
            double yCityToMonster = Math.abs(city.getLocation().getY() - monster.getLocation().getY());
            double distanceCityToMonster = Math.sqrt(xCityToMonster * xCityToMonster + yCityToMonster * yCityToMonster);
            if (distanceCityToMonster < minDistanceToMonster) {
                minDistanceToMonster = distanceCityToMonster;
                closestMonster = monster;
            }
        }
        double distanceCastleToMonster = distanceCastleToCity + minDistanceToMonster;

        System.out.println(String.format("Расстояние от замка Ведьмака (координаты (0, 0)) до города %s - %.1f",
                city.getName(), distanceCastleToCity));
        System.out.println(String.format("Расстояние от города %s (координаты (%s, %s)) до ближайшего монстра - %.1f",
                city.getName(), city.getLocation().getX(), city.getLocation().getY(), minDistanceToMonster));
        System.out.println(String.format("Расстояние от замка до города плюс расстояние от города %s до ближайшего монстра " +
                "составляет %.1f часов. " + "Выбранная цель %s", city.getName(), distanceCastleToMonster, closestMonster.getName()));
    }
}
