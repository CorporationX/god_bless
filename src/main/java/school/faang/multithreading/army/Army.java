package school.faang.multithreading.army;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Army {

  private final List<Unit> units = new ArrayList<>();

  public void addUnit(Unit unit) {
    units.add(unit);
  }

  public int calculateTotalPower() throws InterruptedException {

    var calculators = units.stream()
        .map(PowerCalculator::new)
        .toList();

    var threads = calculators.stream()
        .map(Thread::new)
        .toList();

    threads.forEach(Thread::start);

    for (Thread thread : threads) {
      thread.join();
    }

    return calculators.stream()
        .map(PowerCalculator::getPower)
        .reduce(Integer::sum)
        .orElse(0);
  }
}
