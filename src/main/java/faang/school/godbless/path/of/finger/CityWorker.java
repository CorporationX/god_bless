package faang.school.godbless.path.of.finger;

import lombok.Getter;

import java.util.List;

public class CityWorker implements Runnable {

    private City city;
    private List<Monster> monsters;
    @Getter
    private long result;

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        Monster nearestMonster = null;
        double nearestDistance = Double.MAX_VALUE;
        for (Monster monster : monsters) {
            double distance = city.getLocation().distanceTo(monster.getLocation());
            if (distance < nearestDistance) {
                nearestDistance = distance;
                nearestMonster = monster;
            }
        }

        return nearestMonster;
    }

    public long getKillTime() {
        return 500;
    }

    public long getJourneyDistance() {
        return (long) city.getDistanceFromKaerMorhen();
    }

    @Override
    public void run() {
        Monster nearestMonster = findNearestMonster(city, monsters);
        if (nearestMonster == null) {
            System.out.println("Не найдено монстров для города " + city.getName());
            result = 0L;
            return;
        }

        long journeyTime = getJourneyDistance();
        long killTime = getKillTime();

        System.out.println("Геральт путешествует в " + city.getName() + " и убивает " + nearestMonster.getName());
        try {
            Thread.sleep(journeyTime + killTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        result = journeyTime + killTime;
    }
}
