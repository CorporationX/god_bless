package school.faang.godbless.bjs2_31293;

public class Archer extends Character {

  public Archer(String name) {
    super(name);
    this.strength = 3;
    this.agility = 10;
    this.intelligence = 5;
  }

  public Archer(String name, int strength, int agility, int intelligence) {
    super(name, strength, agility, intelligence);
  }

  @Override
  public void attack(Character character) {
    character.health -= agility;
  }
}
