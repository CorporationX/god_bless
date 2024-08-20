package faang.school.godbless.finger;

import java.util.List;
import java.util.Map;

public class CityWorker implements Runnable{
    private final Map<String, Long> killTime =
            Map.of(
                    "Griffin", 1000L,
                    "Basilisk", 10000L,
                    "Cockatrice", 2000L,
                    "Chort", 5000L
            );

    private City city;
    private List<Monster> monsters;
    private Monster nearestMonster;

    public CityWorker(City city, List<Monster> monsters) {
        this.monsters = monsters;
        this.city = city;
    }

    @Override
    public void run() {
        System.out.println("start work in " + city.getName());
        nearestMonster = findNearestMonster(city, monsters);
        try {
            Thread.sleep(getKillTime());
            Thread.sleep(getJourneyDistance());
            Thread.sleep(ravishWomen());
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        System.out.println("end work in " + city.getName());
    }

    public Monster findNearestMonster(City city, List<Monster> monsters){
        return monsters.stream()
                .min((m1, m2) -> Math.toIntExact(Location.distance(city.getLocation(), m2.getLocation()) -
                        Location.distance(city.getLocation(), m1.getLocation())))
                .orElse(new Monster("none", new Location(0, 0)));
    }

    public long getKillTime() {
        return killTime.getOrDefault(nearestMonster.getName(), 2000L);//если нет такого монстра в нашем списке,
        // то берем по умолчанию
    }

    public long getJourneyDistance() {
        return city.getDistanceToWitcher();
    }

    public long ravishWomen() {
        return 10L*city.getBeautifulWomenCount();
    }
}
