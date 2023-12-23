package faang.school.godbless.witcher;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class CityWorker implements Runnable {

    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        Monster monster = findNearestMonster(city, monsters);
        try {
            System.out.println("Ближайший монстр к " + city.getName() + " - " + monster.getName());
            Thread.sleep(getJourneyDistance(monster.getLocation(), city.getLocation()));
            Thread.sleep(getKillTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        if (monsters.isEmpty()) {
            throw new IllegalArgumentException("Список монстров пуст");
        }
        return monsters.stream()
                .min(Comparator.comparingLong(monster -> getJourneyDistance(city.getLocation(), monster.getLocation())))
                .orElse(null);

    }

    public long getKillTime() {
        return new Random().nextLong(2000);
    }

    public long getJourneyDistance(Location monsterLocation, Location cityLocation) {
        long x = Math.abs(monsterLocation.getX() - cityLocation.getX());
        long y = Math.abs(monsterLocation.getY() - cityLocation.getY());
        return x + y;
    }
}
