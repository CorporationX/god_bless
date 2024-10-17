package school.faang.multithreading.army;

import lombok.Getter;

public class PowerCalculator implements Runnable {

  private final Unit unit;
  @Getter
  private int power;

  public PowerCalculator(Unit unit) {
    this.unit = unit;
  }

  @Override
  public void run() {
    power = unit.getPower();
  }
}
