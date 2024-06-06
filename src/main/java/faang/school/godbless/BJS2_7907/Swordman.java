package faang.school.godbless.BJS2_7907;

public class Swordman extends Creature {
  public Swordman(int quantity) {
    super("Swordman", 11, 15, 5, 10, quantity);
  }

  @Override
  public int getDamage() {
    return this.getAttack();
  }
}
