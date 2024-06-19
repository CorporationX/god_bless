package faang.school.godbless.bjs2_11906;

import static faang.school.godbless.ColorScheme.RESET;
import static faang.school.godbless.bjs2_11906.Utils.MAX_HABITAT_MONSTER;
import static faang.school.godbless.bjs2_11906.Utils.MAX_MONSTER_COUNT;
import static faang.school.godbless.bjs2_11906.Utils.MAX_MONSTER_POWER;
import static faang.school.godbless.bjs2_11906.Utils.MIN_HABITAT_MONSTER;
import static faang.school.godbless.bjs2_11906.Utils.POOL_SIZE;
import static faang.school.godbless.bjs2_11906.Utils.TIME_OUT;
import static faang.school.godbless.bjs2_11906.Utils.TRAVEL_ALL_WITCHERS_IS_OVER;
import static faang.school.godbless.bjs2_11906.Utils.generateRandomLocation;
import static faang.school.godbless.bjs2_11906.Utils.getMonsterName;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

  public static void main(String[] args) {

    List<City> cities = List.of(new City("Novigrad", generateRandomLocation()),
        new City("Oxenfurt", generateRandomLocation()),
        new City("Vizima", generateRandomLocation()),
        new City("Kaer Morhen", generateRandomLocation()));

    List<Witcher> witchers = List.of(new Witcher("Геральт", generateRandomLocation(), "Школа Волка"),
        new Witcher("Айден", generateRandomLocation(), "Школа Кота"),
        new Witcher("Иван", generateRandomLocation(), "Школа Мантикоры"),
        new Witcher("Койон", generateRandomLocation(), "Школа Грифона"));

    List<String> monsterName = List.of("Griffin", "Basilisk", "Cockatrice", "Chort");

    List<Monster> monsters = new ArrayList<>();

    cities.forEach(city -> {
      final int monsterCount = new Random().nextInt(MAX_MONSTER_COUNT);
      for (int i = 0; i < monsterCount; i ++) {
        monsters.add(new Monster(getMonsterName(monsterName), city,
            new Random().nextInt(MIN_HABITAT_MONSTER, MAX_HABITAT_MONSTER),
            new Random().nextInt(MAX_MONSTER_POWER)));
      }
    });

    ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);

    witchers.forEach(witcher -> executorService.submit(new WitcherWorker(witcher, cities, monsters)));

    executorService.shutdown();

    try {
      executorService.awaitTermination(TIME_OUT, TimeUnit.MINUTES);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.out.println(RESET.getColor() + TRAVEL_ALL_WITCHERS_IS_OVER);
  }
}
