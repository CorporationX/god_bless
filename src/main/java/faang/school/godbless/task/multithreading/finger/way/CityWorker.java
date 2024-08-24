package faang.school.godbless.task.multithreading.finger.way;

import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CityWorker implements Runnable {
    private static final int TIME_DISTANCE_COEFFICIENT = 200;

    private final Distance distance = new Distance();
    private final City city;
    private final List<Monster> monsters;
    private final Location geraldLocation;
    private double distanceToCity;
    private double distanceToMonster;
    private double journeyDistance;
    private Monster monster;
    private Long killingTime;

    @Override
    public void run() {
        collectInformation();
        System.out.println("\nРасчет по городу %s".formatted(city.getName()) +
                "\nРасстояние до города %s: %s миль".formatted(city.getName(), distanceToCity) +
                "\nБлижайший монстер к городу %s: %s".formatted(city.getName(), monster.getName()) +
                "\nОбщее время на убийство %s: %s миллисекунд".formatted(monster.getName(), killingTime) +
                "\nОбщее расстояние путешествия до %s: %s миль".formatted(monster.getName(), journeyDistance));
    }

    private void collectInformation() {
        monster = findNearestMonster();
        distanceToCity = distance.get(geraldLocation, city.getLocation());
        killingTime = getKillTime();
        journeyDistance = getJourneyDistance();
    }

    private Monster findNearestMonster() {
        return getNearestMonster()
                .stream()
                .peek(e -> distanceToMonster = e.getValue())
                .map(Map.Entry::getKey)
                .findAny()
                .get();
    }

    private Optional<Map.Entry<Monster, Double>> getNearestMonster() {
        return getMonsterMap()
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(Map.Entry<Monster, Double>::getValue));
    }

    private Map<Monster, Double> getMonsterMap() {
        return monsters.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        mons -> distance.get(city.getLocation(), mons.getLocation())));
    }

    private long getKillTime() {
        return journeyDistance != 0 ?
                (long) journeyDistance * TIME_DISTANCE_COEFFICIENT + monster.getTimeToKill() :
                TIME_DISTANCE_COEFFICIENT + monster.getTimeToKill();
    }

    private double getJourneyDistance() {
        return distanceToCity + distanceToMonster;
    }
}
