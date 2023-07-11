package faang.school.godbless.finger_path;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class CityWorker implements Runnable {

    private final City city;
    private final List<Monster> monsters;

    Random random = new Random();

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        return monsters.stream()
            .min(Comparator.comparingInt(monster -> getJourneyDistance(city.getLocation(), monster.getLocation())))
            .orElse(null);
    }

    @SneakyThrows
    public long getKillTime(Monster monster) {
        int monsterHealth = monster.getHealth();
        long millisecondsToKill = 0;

        while (monsterHealth > 0) {
            monsterHealth -= random.nextInt(100);
            int timeToSleep = random.nextInt(1_000);
            Thread.sleep(timeToSleep);
            millisecondsToKill += timeToSleep;
        }

        return millisecondsToKill;
    }

    private static int getJourneyDistance(Location start, Location destination) {
        int xDiff = start.getLatitude() - destination.getLatitude();
        int yDiff = start.getLongitude() - destination.getLongitude();

        return (int) Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    @Override
    public void run() {
        Monster nearestMonster = findNearestMonster(city, monsters);

        long timeToKillMonster = getKillTime(nearestMonster) / 1_000;

        System.out.println("Nearest monster is " + nearestMonster.getName());
        System.out.println("Monster is located in " + nearestMonster.getPlace());
        System.out.println("Time to kill it: " + timeToKillMonster + " sec.\n");
    }
}
