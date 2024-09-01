package faang.school.godbless.wither.monster.map;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class CityWorker implements Runnable {
    private final City city;
    private final Witcher witcher;
    private final Monster nearestMonster;

    public CityWorker(City city, Witcher witcher) {
        this.city = city;
        this.witcher = witcher;
        this.nearestMonster = findNearestMonster(witcher.getMonsters());
    }

    @Override
    public void run() {
        try {
            System.out.printf("The city %s is looking for nearest monster\n", city.getName());
            TimeUnit.SECONDS.sleep(1);
            System.out.printf("For city %s the nearest monster's name is %s\n", city.getName(), nearestMonster.getName());
            System.out.printf("The route \"Herald - city %s - place %s (monster %s)\" has been built\n Distance is %d\n", city.getName(), nearestMonster.getPlace(), nearestMonster.getName(), getJourneyDistance());
        } catch (InterruptedException exception) {
            log.error(String.format("Thread was interrupted while \"Herald - city %s - monster %s\" was calculated", city.getName(), nearestMonster.getName()), exception);
            Thread.currentThread().interrupt();
        }
    }

    private Monster findNearestMonster(List<Monster> monsters) {
        if (monsters == null || monsters.isEmpty()) {
            throw new IllegalArgumentException("Monsters shouldn't be null or empty");
        }

        Map<Monster, Integer> monsterDistanceEstimate = monsters.stream()
                .collect(Collectors.toMap(Function.identity(),
                        monster -> Math.abs(city.getLocation().getX() - monster.getLocation().getX()) +
                                Math.abs(city.getLocation().getY() - monster.getLocation().getY())));

        return monsterDistanceEstimate.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();
    }

    public long getKillTime() {
        return 1L;
    }

    public long getJourneyDistance() {
        return calculateDistance(city.getLocation(), witcher.getLocation()) + calculateDistance(city.getLocation(), nearestMonster.getLocation());
    }

    private long calculateDistance(Location location1, Location location2) {
        return (long) Math.sqrt(Math.pow(location1.getX() - location2.getX(), 2) +
                Math.pow(location1.getY() - location2.getY(), 2));
    }

}
