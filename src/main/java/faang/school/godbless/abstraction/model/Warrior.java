package faang.school.godbless.abstraction.model;

/**
 * @author Evgenii Malkov
 */
public class Warrior extends Character{

  public Warrior(String name) {
    super(name, 10, 5 ,3);
  }

  @Override
  public void attack(Character enemy) {
    int damage = this.power;
    enemy.health -= damage;
  }
}
