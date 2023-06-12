package faang.school.godbless.character;

public class Archer extends Character {
  public static final int DEFAULT_STRENGTH = 3;
  public static final int DEFAULT_AGILITY = 10;
  public static final int DEFAULT_INTELLIGENCE = 5;

  Archer(String name) {
    super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
  }

  @Override
  void attack(Character anotherCharacter) {
    anotherCharacter.health -= DEFAULT_AGILITY;
  }
}
