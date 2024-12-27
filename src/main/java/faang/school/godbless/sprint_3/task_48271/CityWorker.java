package faang.school.godbless.sprint_3.task_48271;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private final City city;
    private final List<Monster> monsters;

    @Override
    public void run() {
        Monster closestMonsterToCity = monsters.remove(monsters.size() - 1);
        double distanceFromCityToClosestMonster = getDistanceToCity() - getDistanceToMonster(closestMonsterToCity);
        for (Monster monster : monsters) {
            double distanceFromCityToMonster = getDistanceToCity() - getDistanceToMonster(monster);
            if (distanceFromCityToClosestMonster > distanceFromCityToMonster) {
                closestMonsterToCity = monster;
                distanceFromCityToClosestMonster = distanceFromCityToMonster;
            }
        }
        System.out.println("Расстояние от замка до города \"" + city.getName() + "\": " + getDistanceToCity()
                + ". Расстояние от города до ближайшего монстра \"" + closestMonsterToCity.getName() + "\": "
                + getDistanceToMonster(closestMonsterToCity));
    }

    private double getDistanceToMonster(Monster monster) {
        int x = monster.getLocation().getCoordinateX();
        int y = monster.getLocation().getCoordinateY();
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    private double getDistanceToCity() {
        int x = city.getLocation().getCoordinateX();
        int y = city.getLocation().getCoordinateY();
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}
