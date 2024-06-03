package faang.school.godbless.task_1.creature.models;

import faang.school.godbless.task_1.creature.Creature;

/**
 * Класс Грифона
 */
public class Griffin extends Creature {

  private static final Integer MAX_DEFENSE = 80;

  public Griffin(String creatureName, Integer creatureLevel, Integer creatureDamage,
      Integer creatureDefense, Integer creatureSpeed, Integer creatureQuantity) {
    super(creatureName, creatureLevel, creatureDamage, creatureDefense, creatureSpeed,
        creatureQuantity);
  }

  @Override
  public Integer getDamage() {
    return this.getCreatureQuantity() * (this.getCreatureDamage() + this.getCreatureDefense() +
        this.getCreatureSpeed() + MAX_DEFENSE);
  }
}
