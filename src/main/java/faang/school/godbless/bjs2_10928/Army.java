package faang.school.godbless.bjs2_10928;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Army {

  private static final String DAMAGE = "Урон ";
  private static final String ALL_ARMY_DAMAGE = "Урон всей армии: ";
  private static final String SEPARATOR = " - ";
  private static final int DEFAULT_DAMAGE = 0;

  private int tempAllDamage = DEFAULT_DAMAGE;

  private List<Creature> creatures = new ArrayList<>();
  private Map<String, Integer> allDamageCreature = new HashMap<>();

  public Army(List<Creature> creatures) {
    this.creatures = creatures;
  }

  /**
   * Метод в отдельном потоке считает силу каждого отдельного отряда
   */
  public void calculateTotalPower() {
    final var armies = creatures.stream()
        .collect(Collectors.groupingBy(creature -> creature.getClass().getSimpleName()));
    armies.forEach((key, value) -> {
      value.forEach(creature -> {
        PowerThread powerThread = new PowerThread(creature);
        powerThread.start();
        tempAllDamage += getFullPDamage(powerThread);
        allDamageCreature.put(key, tempAllDamage);
      });
      tempAllDamage = DEFAULT_DAMAGE;
    });

    allDamageCreature.forEach((key, value) -> {
      System.out.println(DAMAGE + key + SEPARATOR + value);
      tempAllDamage += value;
    });
    System.out.println(ALL_ARMY_DAMAGE + tempAllDamage);
  }

  /**
   * Метод для получения урона существа из определенного потока
   * @param powerThread объект потока
   * @return рассчитанный урон существа
   */
  private int getFullPDamage(PowerThread powerThread) {
    try {
      powerThread.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    return powerThread.getDamage();
  }

  /**
   * Метод для добавления нового существа в текущую армию.
   * @param creature существо
   */
  public void addUnit(Creature creature) {
    this.creatures.add(creature);
  }

}
