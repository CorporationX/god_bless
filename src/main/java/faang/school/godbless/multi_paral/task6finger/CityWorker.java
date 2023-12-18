package faang.school.godbless.multi_paral.task6finger;

import java.util.List;
import java.util.Random;

public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;
    private Location currentLocation = new Location(0, 0);

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    @Override
    public void run() {
        try {
            Monster nearestMonster = findNearestMonster(city, monsters);
            long journeyTime = getJourneyDistance();

            Thread.sleep(journeyTime);

            long killTime = getKillTime();

            Thread.sleep(killTime);

            System.out.println("Геральт путешествовал до " + city.getName() +
                    " и убил " + nearestMonster.getName() +
                    ". Время в пути: " + journeyTime / 10 + "ч" +
                    ", время на убийство: " + killTime / 100 + "мин");

            currentLocation = city.getLocation();

        } catch (InterruptedException e) {
            System.err.println("Произошла ошибка загрузки карты");
        }

    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        // Сравниваем по расстоянию до города, distanceTo это расстояние между location-ми
        return monsters.stream()
                .min((monster1, monster2) -> (int) (monster1.getLocation().distanceTo(city.getLocation())
                        - monster2.getLocation().distanceTo(city.getLocation()))).orElseThrow();
    }

    public Long getKillTime() {
        return 1000 * (new Random().nextLong(5) + 1) + new Random().nextLong(10) * 100;
    }

    public long getJourneyDistance() {
        return (long) currentLocation.distanceTo(city.getLocation());
    }
}
