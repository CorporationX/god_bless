package faang.school.godbless.multithreading_parallelism.task_7;

import lombok.NonNull;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public record CityWorker(City city, List<Monster> monsters) implements Runnable {
    private static final int MIN_KILL_TIME = 2000;
    private static final int MAX_KILL_TIME = 7000;

    @Override
    public void run() {
        System.out.println("Nearest monster to " + city + " is " + findNearestMonster());
        System.out.println("Time to kill monster is " + getKillTime() + " milliseconds");
        System.out.println("Distance to the city is " + getJourneyDistance());
    }

    public Monster findNearestMonster() {
        return monsters.stream()
                .min(this::compareMonsterLocation)
                .orElseThrow(() -> new NoSuchElementException("An error occurred while searching for a monster"));
    }

    private int compareMonsterLocation(@NonNull Monster monster, @NonNull Monster otherMonster) {
        return monster.getLocation().compareLocation(otherMonster.getLocation(), city.location());
    }

    public long getKillTime() {
        return new Random().nextInt(MIN_KILL_TIME, MAX_KILL_TIME + 1);
    }

    public long getJourneyDistance() {
        return city.distance();
    }
}
