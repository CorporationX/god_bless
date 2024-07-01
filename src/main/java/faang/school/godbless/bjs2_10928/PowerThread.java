package faang.school.godbless.bjs2_10928;

import lombok.Getter;

public class PowerThread extends Thread {

  private static final String DAMAGE_CALCULATION = " Расчет силы юнитов - ";

  private Creature creature;

  @Getter
  private int damage;

  public PowerThread(Creature creature) {
    this.creature = creature;
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread() + DAMAGE_CALCULATION + creature.getClass().getSimpleName());
    damage = creature.calculateDamage();
  }
}
