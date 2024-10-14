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
        int cityLocationX = city.getLocation().getX();
        int cityLocationY = city.getLocation().getY();
        double distanceToCity = Math.sqrt(Math.pow(-cityLocationX, 2) + Math.pow(-cityLocationY, 2));
        double minDistanceFromCityToMonster = Integer.MAX_VALUE;
        String monsterName = null;
        for (Monster monster : monsters) {
            double distance = Math.sqrt(Math.pow(cityLocationX - monster.getLocation().getX(), 2) + Math.pow(cityLocationY - monster.getLocation().getY(), 2));
            if (distance < minDistanceFromCityToMonster) {
                minDistanceFromCityToMonster = distance;
                monsterName = monster.getName();
            }
        }
        System.out.printf("Расстояние до города %s равно %f, расстояние от этого города до ближайшего монстра %s равно %f",
                getCity().getName(), distanceToCity, monsterName, minDistanceFromCityToMonster);
        System.out.println();
    }
}