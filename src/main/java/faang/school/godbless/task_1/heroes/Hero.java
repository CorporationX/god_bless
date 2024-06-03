package faang.school.godbless.task_1.heroes;

import faang.school.godbless.task_1.creature.Creature;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * Класс героя.
 */
@Data
public class Hero {

  private String heroName;
  private String heroFaction;
  private Integer heroExperience;
  private Integer heroLevel;

  //TODO можно подумать над использованием других коллекций, чтобы зранить существ.
  private List<Creature> heroesArmy = new ArrayList<>();

  public Hero(String heroName, String heroFaction, Integer heroExperience, Integer heroLevel) {
    this.heroName = heroName;
    this.heroFaction = heroFaction;
    this.heroExperience = heroExperience;
    this.heroLevel = heroLevel;
  }

  /**
   * Метод, который позволяет добавлять сушеств в армию героя.
   * @param creature Добавляемое существо.
   * @param quantity Колличество добавляемых существ.
   */
  public void addCreature(Creature creature, int quantity) {
    for (int i = 0; i < quantity; i++) {
      heroesArmy.add(creature);
    }
  }

  /**
   * Метод, который позволяет убирать сушеств из армии героя.
   * @param creature Удаляемое существо.
   * @param quantity Колличество удаляемых существ.
   */
  public void removeCreature(Creature creature, int quantity) {
    int count = 0;
    for (int i = 0; i < heroesArmy.size(); i++) {
      if (heroesArmy.get(i).equals(creature)) {
        heroesArmy.remove(i);
        count++;
        i--;
      }
      if (count == quantity) {
        break;
      }
    }
  }

  /**
   * Получить текущую армию героя.
   * @return текущая апмия героя.
   */
  public List<Creature> getArmy() {
    return heroesArmy;
  }

}
