package faang.school.godbless.multithreading.witcher;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;

@Slf4j
public record CityWorker(City city, List<Monster> monsters) implements Runnable {

    public Monster findNearestMonster() {
        int distance = Integer.MAX_VALUE;
        Monster nearestMonster = null;
        var cityLocation = city.location();
        for (Monster monster : monsters) {
            var currentX = Math.abs(cityLocation.x() - monster.getLocationCoordinates().x());
            var currentY = Math.abs(cityLocation.y() - monster.getLocationCoordinates().y());
            var currentSum = currentX + currentY;
            if (currentSum < distance) {
                distance = currentSum;
                nearestMonster = monster;
            }
        }
        return nearestMonster;
    }

    public long getKillTime() {
        return new Random().nextInt(1000, 4000);
    }

    public long getJourneyDistance() {
        return city.distanceToWitcher();
    }

    @Override
    public void run() {
        log.info("Nearest monster to city {}: {}", this.city.name(), findNearestMonster());
        log.info("Distance to travel: {}", getJourneyDistance());
        var killTime = getKillTime();
        log.info("Time to kill: {}", killTime);
        try {
            Thread.sleep(killTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
