package faang.school.godbless.multithreading.witcher;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        Monster nearestMonster = findNearestMonster();
        int distance = getJourneyDistance(city, nearestMonster);
        long killTime = getKillTime(nearestMonster);
        try {
            Thread.sleep(killTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Nearest monster - %s | Journey Distance - %s | City - %s | Kill time - %sms (%s)\n",
                nearestMonster.getName(), distance, city.getName(), killTime, Thread.currentThread().getName());
    }

    public Monster findNearestMonster() {
        return monsters.stream()
                .min(Comparator.comparingInt
                        (monster -> getJourneyDistance(city, monster)))
                .orElse(null);
    }

    public int getJourneyDistance(City city, Monster monster) {
        return city.getLocation().calculateDistance(monster.getLocation()) + city.getDistance();
    }

    public long getKillTime(Monster monster) {
        return monster.getName().length() * 100L;
    }
}
