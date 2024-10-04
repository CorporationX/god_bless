package school.faang.godbless.bjs2_31293;

public class Archer extends Character {

  private static final int DEFAULT_STRENGTH = 3;
  private static final int DEFAULT_AGILITY = 10;
  private static final int DEFAULT_INTELLIGENCE = 5;

  public Archer(String name) {
    super(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLIGENCE);
  }

  public Archer(String name, int strength, int agility, int intelligence) {
    super(name, strength, agility, intelligence);
  }

  @Override
  public void attack(Character character) {
    character.setHealth(character.getHealth() - super.getAgility());
  }
}
