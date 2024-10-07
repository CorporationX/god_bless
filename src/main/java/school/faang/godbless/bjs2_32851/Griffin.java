package school.faang.godbless.bjs2_32851;

public class Griffin extends Creature {

  private static final int ATTACK = 30;
  private static final int DEFENSE = 25;
  private static final int SPEED = 30;

  public Griffin(String name, int level) {
    super.setName(name);
    super.setLevel(level);
    super.setAttack(ATTACK);
    super.setDefence(DEFENSE);
    super.setSpeed(SPEED);
  }

  @Override
  public int getDamange() {
    return super.getSpeed() * super.getLevel() + super.getAttack();
  }
}
