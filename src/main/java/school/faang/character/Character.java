package school.faang.character;

import lombok.Data;

@Data
public abstract class Character {
  protected String name;
  protected int power;
  protected int agility;
  protected int intellect;
  protected int health = 100;

  Character(String name) {
    this.name = name;
  }

  Character(String name, int power, int agility, int intellect) {
    this.name = name;
    this.power = power;
    this.agility = agility;
    this.intellect = intellect;
  }

  public void damage(int damage) {
    this.health -= damage;
  }

  public abstract void attack(Character character);
}
