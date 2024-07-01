package faang.school.godbless.bjs2_10928;

public class Swordsman extends Creature {

  private static final Integer DEFENSE = 80;

  public Swordsman(int damage) {
    super(damage);
  }

  //TODO не совсем пока понял, где нужно использовать synchronized
  //TODO и вообще на сколько он актуален для данной задачи
  @Override
  public synchronized int calculateDamage() {
    return this.getDamage() + DEFENSE;
  }

}
