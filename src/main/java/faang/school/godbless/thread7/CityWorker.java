package faang.school.godbless.thread7;

import java.util.List;

public record CityWorker(City city, List<Monster> monsters) implements Runnable {
    private static final String ERROR = "Не смогли убить монстра: ";
    private static final String MESSAGE_NEAREST_MONSTER = "Ближайший монстр к городу %s - %s\n";
    private static final String MESSAGE_KILL_TIME = "Время затраченное на убийство монстра - %d\n";
    private static final String MESSAGE_DISTANCE_TO_CITY = "Расстояние до города - %d\n";

    @Override
    public void run() {
        System.out.format(MESSAGE_NEAREST_MONSTER, city.name(), findNearestMonster(city, monsters).name());
        try {
            Thread.sleep(getKillTime());
        } catch (InterruptedException e) {
            throw new RuntimeException(ERROR + e.getMessage());
        }
        System.out.format(MESSAGE_KILL_TIME, getKillTime());
        System.out.format(MESSAGE_DISTANCE_TO_CITY, getJourneyDistance());
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        int minDistance = Integer.MAX_VALUE;
        Monster nearestMonster = null;
        for (Monster monster : monsters) {
            int distance = getDistance(city, monster);
            if (distance < minDistance) {
                minDistance = distance;
                nearestMonster = monster;
            }
        }
        return nearestMonster;
    }

    private static int getDistance(City city, Monster monster) {
        int deltaX = Math.abs(city.location().coordinateX() - monster.location().coordinateX());
        int deltaY = Math.abs(city.location().coordinateY() - monster.location().coordinateY());
        return (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    public long getKillTime() {
        return (long) ((Math.random() + 1) * 10);
    }

    public long getJourneyDistance() {
        return city.distanceToTheWitcher();
    }
}
