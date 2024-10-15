package school.BJS2_36302;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    @Getter
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        double distanceToCity = distanceToCIty(city);
        Monster monsterWithMinDistance = monsters.stream().min((monster1, monster2) -> {
            double distanceToMonster1 = distanceToMonsterFromCity(city, monster1);
            double distanceToMonster2 = distanceToMonsterFromCity(city, monster2);
            return Double.compare(distanceToMonster1, distanceToMonster2);
        }).get();
        double minDistanceFromCityToMonster = distanceToMonsterFromCity(city, monsterWithMinDistance);
        System.out.printf("Расстояние до города %s равно %f, расстояние от этого города до ближайшего монстра %s равно %f",
                getCity().getName(), distanceToCity, monsterWithMinDistance.getName(), minDistanceFromCityToMonster);
        System.out.println();
    }

    private double distanceToCIty(City city) {
        return Math.sqrt(Math.pow(city.getLocation().getX(), 2) + Math.pow(city.getLocation().getY(), 2));
    }

    private double distanceToMonsterFromCity(City city, Monster monster) {
        return Math.sqrt(Math.pow(city.getLocation().getX() - monster.getLocation().getX(), 2) + Math.pow(city.getLocation().getY() - monster.getLocation().getY(), 2));
    }
}