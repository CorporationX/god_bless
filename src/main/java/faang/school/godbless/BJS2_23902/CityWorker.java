package faang.school.godbless.BJS2_23902;

import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class CityWorker implements Runnable {

    private final City city;
    private final List<Monster> monsters;
    private final Random random = new Random();

    @Override
    public void run() {
        try {
            Monster nearestMonster = findNearestMonster();
            System.out.println(Thread.currentThread().getName() + ": Nearest monster to city " + city.getName() + " is " + nearestMonster.getName());
            System.out.println(Thread.currentThread().getName() + ": Call the Wither for help, distance between him and " + city.getName() + " = " + getJourneyDistance());

            Thread.sleep(getJourneyDistance() * 100);

            System.out.println(Thread.currentThread().getName() + ": Wither arrived at city " + city.getName() + " and began to battle with the " + nearestMonster.getName());

            Thread.sleep(getKillTime());

            System.out.println(Thread.currentThread().getName() + ": Wither defeated at city " + city.getName() + " the monster " + nearestMonster.getName());

        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted");
        }
    }

    public Monster findNearestMonster() {
        Location cityLocation = city.getLocation();
        return monsters.stream()
                .min(Comparator.comparingDouble(m -> cityLocation.calculateDistance(Location.getLocationCoordinates(m.getLocation()))))
                .orElseThrow();
    }

    public long getKillTime() {
        return ((random.nextInt(10) + 1) * 1000);
    }

    public long getJourneyDistance() {
        return city.getDistanceToWither();
    }

}
