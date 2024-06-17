package faang.school.godbless.BJS2_12192;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
  private String chore;

  @Override
  public void run() {
    System.out.println("Выполняется задача " + Thread.currentThread().getName());
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
