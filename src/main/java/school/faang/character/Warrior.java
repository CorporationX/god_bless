package school.faang.character;

public class Warrior extends Character {

  public Warrior(String name) {
    super(name);
    this.power = 10;
    this.agility = 5;
    this.intellect = 3;
  }

  @Override
  public void attack(Character character) {
    character.setHealth(character.getHealth() - this.power);
  }
}
