package faang.school.godbless.character;

public class Warrior extends Character {
  public static final int DEFAULT_STRENGTH = 10;
  public static final int DEFAULT_AGILITY = 5;
  public static final int DEFAULT_INTELLIGENCE = 3;

  public Warrior(String name) {
    super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
  }

  @Override
  public void attack(Character anotherCharacter) {
    anotherCharacter.health -= DEFAULT_STRENGTH;
  }
}
