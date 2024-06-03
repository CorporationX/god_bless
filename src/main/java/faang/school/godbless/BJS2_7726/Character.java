package faang.school.godbless.BJS2_7726;

import lombok.Data;

@Data
public abstract class Character {
  private String name;
  private int power;
  private int dexterity;
  private int intelligence;
  private int health;

  Character(String name) {
    this.name = name;
    this.health = 100;
  }

  public Character(String name, int power, int dexterity, int intelligence) {
    this.name = name;
    this.power = power;
    this.dexterity = dexterity;
    this.intelligence = intelligence;
    this.health = 100;
  }

  public abstract void attack(Character character);
}
