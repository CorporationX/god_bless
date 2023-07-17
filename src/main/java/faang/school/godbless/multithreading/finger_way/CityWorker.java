package faang.school.godbless.multithreading.finger_way;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CityWorker implements Runnable {
    private final City city;
    private final List<Monster> monsters;

    @Override
    public void run() {
        System.out.println(
                "Nearest monster to city " + city.getName() + " is " + findNearestMonster().getName()
        );
        System.out.println(
                "Time to kill it is " + getKillTime() + " hours"
        );
        System.out.println(
                "Distance to the city: " + getJourneyDistance()
        );
    }

    private Monster findNearestMonster() {
        return monsters.stream()
                .min(Comparator.comparingInt(monster -> city.getLocation().getDistance(monster.getVillageLocation())))
                .orElseThrow();
    }

    private long getKillTime() {
        return new Random().nextLong(2, 10);
    }

    public long getJourneyDistance() {
        return city.getDistance();
    }
}
