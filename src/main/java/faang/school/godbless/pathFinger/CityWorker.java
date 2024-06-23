package faang.school.godbless.pathFinger;

import java.util.Comparator;
import java.util.List;

public class CityWorker implements Runnable {
    private List<Monster> monsters;
    private Witcher witcher;
    private City city;

    public CityWorker(List<Monster> monsters, Witcher witcher, City city) {
        checkingIncomingDataToConstructor(monsters, witcher, city);
        this.monsters = monsters;
        this.witcher = witcher;
        this.city = city;
    }

    @Override
    public void run() {
        getJourneyDistance(city);
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        return monsters.stream()
                .min(Comparator.comparing(
                        monster -> monster.getLocation().getDistanceBetweenTwoLocations(city.getLocation())))
                .orElseThrow(() -> new IllegalArgumentException("No monsters found near the city"));
    }

    public long getJourneyDistance(City city) {
        if (city == null) {
            throw new IllegalArgumentException("The getJourneyDistance method received a non-existent City");
        }
        return city.getLocation().getDistanceBetweenTwoLocations(city.getLocation()) / witcher.getSpeed() + getKillTime();
    }

    private long getKillTime() {
        return city.getMonsterKillTime().get(findNearestMonster(city, monsters));
    }

    private void checkingIncomingDataToConstructor(List<Monster> monsters, Witcher witcher, City city) {
        if (monsters.isEmpty() || monsters == null) {
            throw new IllegalArgumentException(
                    "The construct contains an empty or non-existent List<Monster> of the CityWorker class");
        }
        if (witcher == null) {
            throw new IllegalArgumentException("A non-existent Wither came to construct the City Worker class");
        }
        if (city == null) {
            throw new IllegalArgumentException("A non-existent City came to construct the City Worker class");
        }
    }
}
