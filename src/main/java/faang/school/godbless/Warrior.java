package faang.school.godbless;

/**
 * Класс Воина.
 */
public class Warrior extends Character {

  private static final Integer DEFAULT_WARRIOR_STRENGTH = 10;
  private static final Integer DEFAULT_WARRIOR_DEXTERITY = 5;
  private static final Integer DEFAULT_WARRIOR_INTELLECT = 3;

  public Warrior(String nameCharacter) {
    super(nameCharacter, DEFAULT_WARRIOR_STRENGTH, DEFAULT_WARRIOR_DEXTERITY, DEFAULT_WARRIOR_INTELLECT);
  }

  /**
   * Воин наносит урон противнику в количестве собственной силы.
   * У противника отнимается столько же очков здоровья, сколько он получает урона;
   * @param character персонаж, которого атакует воин.
   */
  @Override
  void attack(Character character) {
    character.setHealth(character.health - this.strength);
  }

}
