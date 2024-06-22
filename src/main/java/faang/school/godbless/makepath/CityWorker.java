package faang.school.godbless.makepath;

import java.util.List;
import java.util.OptionalDouble;

public class CityWorker implements  Runnable{
    @Override
    public void run() {

    }
    private double findDistance(Location a,Location b) {
        return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
    }
    public Monster findNearestMonster(City city, List<Monster> monsters) {
        Location cityLocation = city.getLocation();
        List<Location> monsterLocations = monsters.stream().map(Monster::getLocation).toList();
        Monster closestMonster = monsters.stream().sorted((a,b)->{
            return (int) (findDistance(a.getLocation(),cityLocation)-findDistance(b.getLocation(),cityLocation));
        }).toList().get(0);
        double distance = monsterLocations.stream().mapToDouble(el->findDistance(cityLocation,el)).min().orElse(0);
        return closestMonster;
    }
    public long getKillTime() throws InterruptedException {
        Thread.sleep(500);
        return 1L;
    }
}
