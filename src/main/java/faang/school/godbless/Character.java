package faang.school.godbless;

import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

/**
 * Базовый (обобщенный) класс для описания персонажа.
 */
@Setter
@ToString
@EqualsAndHashCode
public abstract class Character {

  private static final Integer MAX_HEALTH_CHARACTER = 100;

  protected String nameCharacter;
  protected Integer strength;
  protected Integer dexterity;
  protected Integer intellect;
  protected Integer health;

  public Character(String nameCharacter) {
    this.nameCharacter = nameCharacter;
  }

  public Character(String nameCharacter, Integer strength, Integer dexterity, Integer intellect) {
    this(nameCharacter);
    this.strength = strength;
    this.dexterity = dexterity;
    this.intellect = intellect;
    this.health = MAX_HEALTH_CHARACTER;
  }

  /**
   * Общий метод атаки персонажа.
   * @param character персонаж, которого атакует другой персонаж.
   */
  abstract void attack(Character character);

}
