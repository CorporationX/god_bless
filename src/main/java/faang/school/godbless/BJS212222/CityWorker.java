package faang.school.godbless.BJS212222;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CityWorker implements Runnable {

    private Location geraltLocation;
    private City city;
    private List<Monster> monsters;
    @Override
    public void run() {
        String monstersName = findNearestMonster(city, monsters).getName();
        System.out.println("Nearest monster to city " + city.getName() +
                " is " + monstersName);
        System.out.println("Time to kill " + monstersName + ": " + getKillTime() + " parrots");
        System.out.println("Distance from Geralt to the " + city.getName() +
                ": " + getDistance(geraltLocation) + " parrots");
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        if (monsters == null || monsters.isEmpty()) {
            throw new IllegalArgumentException("List monsters can't be null or empty");
        }

        Map<Monster, Integer> monstersMap = monsters.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(m -> m,
                        m -> getDistance(m.getLocation())
                ));
        return monstersMap.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow(IllegalArgumentException::new);
    }

    public long getKillTime() {
        long killTime = (long) ((Math.random() + 1) * 5);
        try {
            Thread.sleep(killTime * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Something went wrong: " + e.getMessage());
        }
        return killTime;
    }

    public int getDistance(Location location) {
        return Math.abs(city.getLocation().getX() - location.getX())
                + Math.abs(city.getLocation().getY() - location.getY());
    }

    public CityWorker(City geraltLocation, City destiny, List<Monster> monsters) {
        this.geraltLocation = geraltLocation.getLocation();
        this.city = destiny;
        this.monsters = monsters;
    }
}
