package school.faang.godbless.bjs2_31293;

import lombok.Data;

@Data
public abstract class Character implements Attack {

  private String name;
  private int strength;
  private int agility;
  private int intelligence;
  private int health = 100;

  public Character(String name) {
    this.name = name;
  }

  public Character(String name, int strength, int agility, int intelligence) {
    this.name = name;
    this.strength = strength;
    this.agility = agility;
    this.intelligence = intelligence;
  }
}
