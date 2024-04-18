package faang.school.godbless.module.third.parallelism.finger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;
    
    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = new ArrayList<>(monsters);
    }
    
    @Override
    public void run() {
        String cityName = city.getName();
        System.out.printf("Ведьмак в городе %s с координатами %s %n", cityName, city.getLocation());
        Location currentLocation = city.getLocation();
        while (monsters.size() != 0) {
            Monster nearestMonster = findNearestMonster(currentLocation, monsters);
            getJourneyDistance(currentLocation, nearestMonster.getLocation());
            long killTime = getKillTime();
            System.out.printf(
                "Ведьмак убивает монстра %s в городе %s за %d миллисекунд %n",
                nearestMonster.getName(),
                cityName,
                killTime
            );
            try {
                Thread.sleep(killTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            currentLocation.setLocation(nearestMonster.getLocation());
            monsters.remove(nearestMonster);
            System.out.printf("Ведьмак идёт дальше по городу %s %n", cityName);
        }
        System.out.printf("Ведьмак разобрался со всеми монстрами в городе %s %n", cityName);
    }
    
    private Monster findNearestMonster(Location location, List<Monster> monsters) {
        Optional<Monster> optionalMonster = monsters.stream()
            .min(Comparator.comparing((monster) -> getJourneyDistance(location, monster.getLocation())))
            .stream()
            .findFirst();
        return optionalMonster.orElse(null);
    }
    
    private long getKillTime() {
        return new Random().nextLong(100, 500);
    }
    
    private long getJourneyDistance(Location now, Location heading) {
        return now.getDistance(heading);
    }
}
