package faang.school.godbless.task_1.creature.models;

import faang.school.godbless.task_1.creature.Creature;

/**
 * Класс Копейщика
 */
public class Pikeman extends Creature {

  private static final Integer MAX_DEXTERITY = 10;

  public Pikeman(String creatureName, Integer creatureLevel, Integer creatureDamage,
      Integer creatureDefense, Integer creatureSpeed, Integer creatureQuantity) {
    super(creatureName, creatureLevel, creatureDamage, creatureDefense, creatureSpeed,
        creatureQuantity);
  }

  @Override
  public Integer getDamage() {
    return this.getCreatureQuantity() * (this.getCreatureDamage() +
        this.getCreatureSpeed() + MAX_DEXTERITY);
  }
}
