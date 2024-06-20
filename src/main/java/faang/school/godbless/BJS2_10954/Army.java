package faang.school.godbless.BJS2_10954;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Army {
  private List<Character> units = new ArrayList<>();
  private static final int THREADS = 5;

  public void addUnit(Character character) {
    units.add(character);
  }

  public int calculateTotalPower() {
    int sum = 0;
    List<CharacterThread> characterThreads = new ArrayList<>();
    for (Character unit : units) {
      CharacterThread thread = new CharacterThread(unit);
      thread.start();
      characterThreads.add(thread);
    }

    for (CharacterThread thread : characterThreads) {
      try {
        thread.join();
        sum += thread.getSum();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    return sum;
  }
}
