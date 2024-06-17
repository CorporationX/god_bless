package faang.school.godbless.bjs2_10928;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Creature {
  private int damage;

  /**
   * Метод для получения урона от существа.
   * @return урон, который может нанести существо.
   */
  public abstract int calculateDamage();
}
