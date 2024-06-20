package faang.school.godbless.sprint2.heroes;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

/**
 * @author Evgenii Malkov
 */
@AllArgsConstructor
public class Army {
  private List<Unit> units;
  public void addUnit(Unit unit) {
    units.add(unit);
  }

  @SneakyThrows
  public int calculateTotalPower() {
    int sum = 0;
    List<PowerThread> threads = new ArrayList<>();
    for (Unit unit : units) {
      PowerThread thread = new PowerThread(unit);
      thread.start();
      threads.add(thread);
    }
    for (PowerThread thread : threads) {
      thread.join();
      sum += thread.getSum();
    }
    return sum;
  }
}
