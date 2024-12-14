package school.faang.FingerWay;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CityWorker implements Runnable{
    private City city;
    private List<Monster> monsters;


    @Override
    public void run() {
        double distanceToCity = distanceToCIty(city);
        Monster nearestMonster = monsters.stream().min(
                (o1, o2) -> Double.compare(distanceToMonsterFromCity(city, o1), distanceToMonsterFromCity(city, o2)))
                .get();
        double minDistanceFromCityToMonster = distanceToMonsterFromCity(city, nearestMonster);
        System.out.println("Distance to city: " + distanceToCity + ", distance to nearest monster \"" + nearestMonster.getName() + "\" from city: " + minDistanceFromCityToMonster);

    }

    private double distanceToCIty(City city) {
        return Math.sqrt(Math.pow(city.getLocation().getX(), 2) + Math.pow(city.getLocation().getY(), 2));
    }

    private double distanceToMonsterFromCity(City city, Monster monster) {
        return Math.sqrt(Math.pow(city.getLocation().getX() - monster.getLocation().getX(), 2) + Math.pow(city.getLocation().getY() - monster.getLocation().getY(), 2));
    }

}
