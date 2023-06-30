package faang.school.godbless.fingerPath;

import java.util.List;
import java.util.Random;

public class CityWorker implements Runnable {
  private City city;
  private List<Monster> monsters;

  public CityWorker(City city, List<Monster> monsters) {
    this.city = city;
    this.monsters = monsters;
  }

  public Monster findNearestMonster() {
    int minDistance = Integer.MAX_VALUE;
    Location cityLocation = city.getLocation();

    Monster nearestMonster = null;

    for (Monster monster : monsters) {
      int monsterDistance = Location.getDistance(cityLocation, monster.getLocation());
      if (monsterDistance < minDistance) {
        minDistance = monsterDistance;
        nearestMonster = monster;
      }
    }
    return nearestMonster;
  }

  private long getKillTime() {
    long start = System.currentTimeMillis();
    Random random = new Random();
    try {
      Thread.sleep(random.nextInt(1000));
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    long end = System.currentTimeMillis();

    return end - start;
  }


  public long getJourneyDistance(City firstCity, City secondCity) {
    return Location.getDistance(firstCity.getLocation(), secondCity.getLocation());
  }

  @Override
  public void run() {
    Monster nearestMonster = findNearestMonster();
    long killTime = getKillTime();
    System.out.println("Nearest monster is: " + nearestMonster.getName() + " Killing time: " + killTime);
  }
}
