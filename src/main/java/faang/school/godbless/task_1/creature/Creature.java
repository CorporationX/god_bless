package faang.school.godbless.task_1.creature;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Общий класс описывающий Существо.
 */
@Data
@AllArgsConstructor
public abstract class Creature {

  private String creatureName;
  private Integer creatureLevel;
  private Integer creatureDamage;
  private Integer creatureDefense;
  private Integer creatureSpeed;
  private Integer creatureQuantity;

  /**
   * Метод для получения урона от существа.
   * @return урон, который может нанести существо.
   */
  public abstract Integer getDamage();

}
