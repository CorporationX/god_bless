package school.faang.godbless.bjs2_31293;

public class Warrior extends Character {

  private static final int DEFAULT_STRENGTH = 10;
  private static final int DEFAULT_AGILITY = 5;
  private static final int DEFAULT_INTELLIGENCE = 4;

  public Warrior(String name) {
    super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
  }

  public Warrior(String name, int strength, int agility, int intelligence) {
    super(name, strength, agility, intelligence);
  }

  @Override
  public void attack(Character character) {
    character.setHealth(character.getHealth() - super.getStrength());
  }
}
