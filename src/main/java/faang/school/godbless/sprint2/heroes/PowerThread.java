package faang.school.godbless.sprint2.heroes;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class PowerThread extends Thread {
  private Unit unit;
  @Getter
  private int sum;

  public PowerThread(Unit unit) {
    this.unit = unit;
  }

  @Override
  public void run() {
    log.info(String.format("%s unit power thread started", unit.getPower()));
    sum = unit.getPower();
  }
}
