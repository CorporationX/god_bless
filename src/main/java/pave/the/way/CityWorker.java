package pave.the.way;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;
    private static final double POW = 2.0;

    @Override
    public void run() {
        double cityX = city.getLocation().getCoordinateX();
        double cityY = city.getLocation().getCoordinateY();
        double distanceToCity = Math.sqrt(Math.pow(cityX, POW) + Math.pow(cityY, POW));

        double distBetweenCityAndMonster = Double.MAX_VALUE;
        String monsterName = "";
        for (Monster monster : monsters) {
            double monsterX = monster.getLocation().getCoordinateX();
            double monsterY = monster.getLocation().getCoordinateY();
            double distanceToMonster = Math.sqrt(Math.pow(monsterX, POW) + Math.pow(monsterY, POW));
            if (distanceToCity - distanceToMonster < distBetweenCityAndMonster) {
                monsterName = monster.getName();
                distBetweenCityAndMonster = distanceToCity - distanceToMonster;
            }
        }

        log.info("Расстояние от замка до города {} {}km : Расстояние от города {} до ближайшего монстра {} {}km.",
                city.getName(), distanceToCity, city.getName(), monsterName, distBetweenCityAndMonster);
    }
}
