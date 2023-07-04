package faang.school.godbless.marvel;

public class Superhero {
  private String name;
  private int strength;
  private int agility;
  private int health;

  public Superhero(String name, int strength, int agility) {
    this.name = name;
    this.strength = strength;
    this.agility = agility;
  }

  public String getName() {
    return name;
  }

  public int getStrength() {
    return strength;
  }

  public int getAgility() {
    return agility;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }
}
