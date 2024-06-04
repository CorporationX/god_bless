package faang.school.godbless;

/**
 * Класс Лучника
 */
public class Archer extends Character {
  private static final Integer DEFAULT_ARCHER_STRENGTH = 3;
  private static final Integer DEFAULT_ARCHER_DEXTERITY = 10;
  private static final Integer DEFAULT_ARCHER_INTELLECT = 5;

  public Archer(String nameCharacter) {
    super(nameCharacter, DEFAULT_ARCHER_STRENGTH, DEFAULT_ARCHER_DEXTERITY, DEFAULT_ARCHER_INTELLECT);
  }

  /**
   * Лучник наносит урон противнику в количестве собственной ловкости.
   * У противника отнимается столько же очков здоровья, сколько он получает урона.
   * @param character персонаж, которого атакует лучник.
   */
  @Override
  void attack(Character character) {
    character.setHealth(character.health - this.dexterity);
  }

}
