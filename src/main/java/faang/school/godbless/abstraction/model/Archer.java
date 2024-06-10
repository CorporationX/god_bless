package faang.school.godbless.abstraction.model;

/**
 * @author Evgenii Malkov
 */
public class Archer extends Character{
  public Archer(String name) {
    super(name, 3, 10, 5);
  }

  @Override
  public void attack(Character enemy) {
    int damage = this.dexterity;
    enemy.health -= damage;
  }
}
