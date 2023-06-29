package Sprint_4_Task10;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.List;
import java.util.Random;

@Data
@AllArgsConstructor
public class CityWorker implements Runnable{
    private City city;
    private List<Monster> monster;

    @Override
    public void run() {
        Monster monster = findNearestMonster();
        System.out.println(Thread.currentThread().getName() + " Самый близкий монстр: " + monster);
        System.out.println(Thread.currentThread().getName() + " Время битвы с монстрам: " + getKillTime());
        System.out.println(Thread.currentThread().getName() + " Дистанция до монстра: " + getJourneyDistance());
    }
    public Monster findNearestMonster(){
        int minDistance = Integer.MAX_VALUE;
        Monster nearestMonster = null;
        Location location = city.getLocation();
        for (int i = 0; i < monster.size(); i++) {
            Location locationMonster = getLocationCoordinates(monster.get(i).getLocation());
            if (minDistance > calculateDuration(location, locationMonster)) {
                minDistance = calculateDuration(location, locationMonster);
                nearestMonster = monster.get(i);
            }
        }
        return nearestMonster;
    }
    @SneakyThrows
    public long getKillTime(){
        long timeStart = System.currentTimeMillis();
        Random random = new Random();
        Thread.sleep(random.nextInt(1000));
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;

    }
    @SneakyThrows
    public long getJourneyDistance(){
        long timeStart = System.currentTimeMillis();
        Random random = new Random();
        Thread.sleep(random.nextInt(1000));
        long timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }
    public int calculateDuration(Location start, Location end){
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        return x + y;
    }
    public Location getLocationCoordinates(String location) {
        switch (location) {
            case "Velen" -> {
                return new Location(10, 20);
            }
            case "Toussaint" -> {
                return new Location(40, 50);
            }
            case "White Orchard" -> {
                return new Location(100, 10);
            }
            case "Skellige" -> {
                return new Location(80, 120);
            }
            default -> {
                return new Location(0, 0);
            }
        }
    }

}
