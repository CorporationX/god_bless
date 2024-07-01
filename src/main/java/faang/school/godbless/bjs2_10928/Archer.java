package faang.school.godbless.bjs2_10928;

public class Archer extends Creature {

  private static final Integer CRITICAL_DAMAGE = 2;

  public Archer(int damage) {
    super(damage);
  }

  //TODO не совсем пока понял, где нужно использовать synchronized
  //TODO и вообще на сколько он актуален для данной задачи
  @Override
  public synchronized int calculateDamage() {
    final int defaultDamage = this.getDamage();
    return defaultDamage + (defaultDamage * CRITICAL_DAMAGE);
  }

}
