package school.faang.godbless.bjs2_32851;

import lombok.Data;

public class Swordman extends Creature {

  private static final int ATTACK = 10;
  private static final int DEFENSE = 10;
  private static final int SPEED = 12;

  public Swordman(String name, int level) {
    super.setName(name);
    super.setLevel(level);
    super.setAttack(ATTACK);
    super.setDefence(DEFENSE);
    super.setSpeed(SPEED);
  }

  @Override
  public int getDamange() {
    return super.getAttack() + super.getLevel();
  }
}
