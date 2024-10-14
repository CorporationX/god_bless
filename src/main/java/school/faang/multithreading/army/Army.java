package school.faang.multithreading.army;

import java.util.ArrayList;
import java.util.List;

public class Army {

  private final List<Powerable> units = new ArrayList<>();

  public void addUnit(Powerable man) {
    units.add(man);
  }

  public int calculateTotalPower() throws InterruptedException {
    int threadsCount = units.size();

    Thread[] threads = new Thread[threadsCount];
    int i = 0;
    for (Powerable man : units) {
      threads[i] = new Thread(new PowerCalculator(man));
      threads[i].start();
      i++;
    }

    for (Thread thread : threads) {
      thread.join();
    }

    return PowerCalculator.totalPower;
  }
}
