package school.faang.pavethewaywithyourfinger.maincode;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        double cityDictance = calculateDistanse(city.getLocation(), new Location(0, 0));

        Monster nearestMonster = null;
        double minMonsterDistance = Integer.MAX_VALUE;

        for (Monster monster : monsters) {
            double distanceToMonster = calculateDistanse(monster.getLocation(), city.getLocation());

            if (distanceToMonster < minMonsterDistance)  {
                minMonsterDistance = distanceToMonster;
                nearestMonster = monster;
            }
        }

        if (nearestMonster != null) {
            double totalDistanse = cityDictance + minMonsterDistance;
            System.out.println(totalDistanse);
        }
    }

    private double calculateDistanse(Location loc1, Location loc2) {
        double x = (loc1.getY() - loc2.getY()) * (loc1.getY() - loc2.getY());
        double y = (loc1.getX() - loc2.getX()) * (loc1.getX() - loc2.getX());
        return Math.sqrt(x + y);
    }
}
