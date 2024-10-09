package school.faang.godbless.bjs2_32851;

public class Pikeman extends Creature {

  private static final int ATTACK = 20;
  private static final int DEFENSE = 20;
  private static final int SPEED = 15;

  public Pikeman(String name, int level) {
    super.setName(name);
    super.setLevel(level);
    super.setAttack(ATTACK);
    super.setDefence(DEFENSE);
    super.setSpeed(SPEED);
  }

  @Override
  public int getDamange() {
    return super.getAttack() * super.getLevel();
  }
}
