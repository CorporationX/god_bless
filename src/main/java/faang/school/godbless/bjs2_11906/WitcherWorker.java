package faang.school.godbless.bjs2_11906;

import static faang.school.godbless.bjs2_11906.Utils.FIGHT_TIME_PER_UNIT_FORCE;
import static faang.school.godbless.bjs2_11906.Utils.ROUTE_PLANNING_TIME;
import static faang.school.godbless.bjs2_11906.Utils.TIME_PER_UNIT_OF_TRAVEL;
import static faang.school.godbless.bjs2_11906.Utils.TIME_TAKEN_RECEIVE_TASK;
import static faang.school.godbless.bjs2_11906.Utils.getDistancesBetweenTwoPoints;

import faang.school.godbless.ColorScheme;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WitcherWorker implements Runnable {

  Witcher witcher;
  List<City> cities;
  List<Monster> monsters;

  //TODO Строковые литералы было лениво уже выносить в отдельные константы.
  @Override
  public void run() {
    final String colorScheme = ColorScheme.findByID(new Random().nextInt(ColorScheme.values().length));
    final String witcherName = witcher.getName();
    System.out.println(colorScheme + Thread.currentThread().getName() +
        String.format(" %s Начинает свое путешествие и строит свою карту путешествия.", witcherName));
    try {
      Thread.sleep(ROUTE_PLANNING_TIME);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    var travelMap = getTravelMap(witcher.getLocation());
    travelMap.forEach((travelMapKey, travelMapValue) -> System.out.println(colorScheme + Thread.currentThread().getName() +
        String.format(" ! %s Получает карту путешествия. Город %s находится на расстоянии \"%d\" км.",
            witcherName, travelMapKey.name(), travelMapValue)));

    travelMap.forEach((city, distanceToCity) -> {
      System.out.println(colorScheme + Thread.currentThread().getName() +
          String.format(" %s отправился в город \"%s\"", witcherName, city.name()));
      try {
        Thread.sleep(getJourneyDistance(distanceToCity));
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      witcher.setLocation(city.location());
      System.out.println(colorScheme + Thread.currentThread().getName() +
          String.format(" %s прошел дистанцию %d км. и прибыл в город \"%s\" и получает задание для очистки земель от монстров",
              witcherName, distanceToCity, city.name()));

      try {
        Thread.sleep(TIME_TAKEN_RECEIVE_TASK);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      var monsterMap = getMonstersOnMap(witcher.getLocation(), city);
      monsterMap.forEach((monsterMapKey, monsterMapValue) -> System.out.println(colorScheme + Thread.currentThread().getName() +
          String.format(" !! %s нашел всех монстров. Монстр %s в районе города %s находится на расстоянии \"%d\" км.",
              witcherName, monsterMapKey.getName(), city.name(), monsterMapValue)));

      monsterMap.forEach((currentMonster, currentDistance) -> {
        System.out.println(colorScheme + Thread.currentThread().getName() +
            String.format(" %s отправился на сражение с \"%s\" из земель принадлежащих \"%s\"",
                witcherName, currentMonster.getName(), city.name()));
        try {
          Thread.sleep(getJourneyDistance(currentDistance));
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }

        if (checkActualMonster(currentMonster)) {
          System.out.println(colorScheme + Thread.currentThread().getName() +
              String.format(" %s прошел дистанцию %d км. и вступил в бой монстром \"%s\" из земель принадлежащих \"%s\"",
                  witcherName, currentDistance, currentMonster.getName(), city.name()));
          try {
            Thread.sleep(getKillTime(currentMonster.getMonsterPower()));
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
          System.out.println(colorScheme + Thread.currentThread().getName() +
              String.format(" %s побеждает монстра \"%s\" из земель принадлежащих \"%s\"",
                  witcherName, currentMonster.getName(), city.name()));
          monsterIsDefeated(currentMonster);
        } else {
          System.out.println(colorScheme + Thread.currentThread().getName() +
              String.format(" !!! %s находит монстра \"%s\" из земель принадлежащих \"%s\", но его уже кто-то убил. Печаль",
                  witcherName, currentMonster.getName(), city.name()));
        }
      });
    });
  }

  /**
   * Метод для отметки о победе над монстром
   * @param monster побежденный монстр
   */
  private synchronized void monsterIsDefeated(Monster monster) {
    monster.setIsDefeated(Boolean.TRUE);
  }

  /**
   * Метод для получения построенной карты городов,
   * где города отсортиролванный от меньшего расстояния от ведьмака до максимального
   * @param location текущая локация ведьмака
   * @return Карта с городами.
   */
  private Map<City, Long> getTravelMap(Location location) {
    return cities.stream()
        .map(city -> Map.of(city, getDistancesBetweenTwoPoints(location, city.location())))
        .flatMap(map -> map.entrySet().stream())
        .sorted(Map.Entry.comparingByValue())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, HashMap::new));
  }

  /**
   * Метод для получения списка всех монстров, которые находятся рядом с городом, где сейчас находится ведьмак.
   * Монстры отсортированны от меньшего расстояния от ведьмака до максимального
   * @param location текущая локация ведьмака
   * @param city Текущий город, где находится ведьмак
   * @return список монстров текущего города
   */
  private synchronized Map<Monster, Long> getMonstersOnMap(Location location, City city) {
    return monsters.stream()
        .filter(currentCity -> currentCity.getCity().equals(city))
        .filter(monster -> Boolean.FALSE.equals(monster.getIsDefeated()))
        .map(currentCity -> Map.of(currentCity, getDistancesBetweenTwoPoints(location, currentCity.getLocation())))
        .flatMap(map -> map.entrySet().stream())
        .sorted(Map.Entry.comparingByValue())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, HashMap::new));
  }

  /**
   * Метод для проверки побежден ли монстр к которому добрался ведьмак.
   * @param currentMonster текущий монстр
   * @return побежден монстр или нет
   */
  private synchronized Boolean checkActualMonster(Monster currentMonster) {
    return monsters.stream()
        .filter(city -> currentMonster.getCity().equals(city.getCity()))
        .filter(monster -> Boolean.FALSE.equals(monster.getIsDefeated()))
        .anyMatch(currentMonster::equals);
  }

  /**
   * Метод для получения времени для преодоления дистанции
   * @param distance дистанция
   * @return итоговое время
   */
  private long getJourneyDistance(long distance) {
    return distance * TIME_PER_UNIT_OF_TRAVEL;
  }

  /**
   * Метод для получения времени для битвы с монстром
   * @param power сила монстра
   * @return итоговое время
   */
  private long getKillTime(long power) {
    return power * FIGHT_TIME_PER_UNIT_FORCE;
  }
}
