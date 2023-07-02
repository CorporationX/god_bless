package faang.school.godbless.thirdSprint.Witcher;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City currentCity;
    private City destinationCity;
    private List<Monster> monsters;

    @Override
    public void run() {
        System.out.println("Геральт выдвигается на охоту в новый город!");
        long distance = getJourneyDistance();
        System.out.println("До города назначения придётся пройти " + distance + " км. Похоже путь будет не лёгкий.");
        System.out.println("Геральт добрался до города " + destinationCity.cityName()
                + ". Время найти ближайшего монстра!");
        Monster nearestMonster = findNearestMonster();
        System.out.println("Ведьмак нашёл монстра " + nearestMonster.name() + ". Начинается охота.");
        try {
            Thread.sleep(getKillTime());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(nearestMonster.name() + " повержен! Нужно отпраздновать кружечкой пива в баре.");
    }

    public Monster findNearestMonster() {
        return monsters.stream()
                .min(Comparator.comparingDouble(m -> calculateDistance(destinationCity.location(), m.location())))
                .orElseThrow(() -> new IllegalArgumentException("Illegal city or list value"));
    }

    private double calculateDistance(Location loc1, Location loc2) {
        double deltaX = loc2.x() - loc1.x();
        double deltaY = loc2.y() - loc1.y();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }


    public long getKillTime() {
        return ThreadLocalRandom.current().nextInt(2000);
    }

    public long getJourneyDistance() {
        return Math.abs(destinationCity.distance() - currentCity.distance());
    }
}
