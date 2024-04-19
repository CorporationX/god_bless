package faang.school.godbless.BJS2_5746;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Data
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        System.out.println("Ближайший монстр в" + city.getName() + ", монстр - " + findNearestMonster().getName());
        Monster monster = findNearestMonster();
        System.out.println("Время для убийства: " + getKillTime());
        System.out.println("Расстояние до " + city.getName() + " = " + getJourneyDistance(monster));
    }

    public Monster findNearestMonster() {
        long distance = Long.MAX_VALUE;
        Monster currentMonster = null;
        for (Monster monster : monsters) {
            long distanceBetweenMonsterAndCity = getJourneyDistance(monster);
            if (distanceBetweenMonsterAndCity < distance) {
                distance = distanceBetweenMonsterAndCity;
                currentMonster = monster;
            }
        }
        return currentMonster;
    }

    public long getKillTime() {
        return new Random().nextInt(10);
    }

    public long getJourneyDistance(Monster monster) {
        int difX = city.getLocation().getX() - new Location(0, 0).getLocationCoordinates(monster.getLocation()).getX();
        int difY = city.getLocation().getY() - new Location(0, 0).getLocationCoordinates(monster.getLocation()).getY();
        return Math.abs(difX - difY);
    }
}
