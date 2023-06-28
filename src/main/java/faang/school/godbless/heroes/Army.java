package faang.school.godbless.heroes;

import java.util.ArrayList;
import java.util.List;

public class Army {
  private final List<Unit> units = new ArrayList<>();

  public void addUnit(Unit unit) {
    units.add(unit);
  }

  public int calculateTotalPower() {
    int totalPower = 0;

    for (Unit unit : units) {
      PowerThread thread = new PowerThread(unit.getPower());
      thread.start();

      totalPower += thread.getPower();
    }

    return totalPower;
  }
}
