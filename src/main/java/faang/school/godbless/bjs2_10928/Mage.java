package faang.school.godbless.bjs2_10928;

public class Mage extends Creature {

  private static final Integer ELEMENTAL_DAMAGE = 100;

  public Mage(int damage) {
    super(damage);
  }

  //TODO не совсем пока понял, где нужно использовать synchronized
  //TODO и вообще на сколько он актуален для данной задачи
  @Override
  public synchronized int calculateDamage() {
    return this.getDamage() * ELEMENTAL_DAMAGE;
  }
}
