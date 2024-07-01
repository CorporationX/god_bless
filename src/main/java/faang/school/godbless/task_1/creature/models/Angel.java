package faang.school.godbless.task_1.creature.models;

import faang.school.godbless.task_1.creature.Creature;

/**
 * Класс Ангела
 */
public class Angel extends Creature {

  private static final Integer MAX_CRITICAL_DAMAGE = 5;

  public Angel(String creatureName, Integer creatureLevel, Integer creatureDamage,
      Integer creatureDefense, Integer creatureSpeed, Integer creatureQuantity) {
    super(creatureName, creatureLevel, creatureDamage, creatureDefense, creatureSpeed,
        creatureQuantity);
  }

  @Override
  public Integer getDamage() {
    return this.getCreatureQuantity() * (this.getCreatureDamage() +
        this.getCreatureSpeed() * MAX_CRITICAL_DAMAGE);
  }

}
