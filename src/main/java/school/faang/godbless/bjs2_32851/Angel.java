package school.faang.godbless.bjs2_32851;

public class Angel extends Creature {

  private static final int ATTACK = 40;
  private static final int DEFENSE = 40;
  private static final int SPEED = 100;

  public Angel(String name, int level) {
    super.setName(name);
    super.setLevel(level);
    super.setAttack(ATTACK);
    super.setDefence(DEFENSE);
    super.setSpeed(SPEED);
  }

  @Override
  public int getDamange() {
    return 0;
  }
}
