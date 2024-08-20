package way;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private static final Random RANDOM = new Random();
    @NonNull
    private final City city;
    @NonNull
    private final List<Monster> monsters;

    @Override
    public void run() {
        var nearestMonster = findNearestMonster();
        System.out.printf("Nearest monster to %s is %s%n", city.getName(), nearestMonster.getName());
        System.out.printf("Time to kill %s is %d days%n", nearestMonster.getName(), getKillTime());
        System.out.printf("Witcher need to travel %d sazens%n", getJourneyDistance());
    }

    private Monster findNearestMonster() {
        return monsters.stream()
                .min(Comparator.comparing(
                        m -> city.getLocation().getDistance(m.getLocation())))
                .orElseThrow();
    }

    private int getKillTime() {
        return RANDOM.nextInt(7) + 1;
    }

    private int getJourneyDistance() {
        return city.getDistance();
    }
}
