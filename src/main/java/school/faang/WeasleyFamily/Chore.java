package school.faang.WeasleyFamily;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
  private String chore;

  @Override
  public void run() {
    System.out.printf("обязанность %s выполняется в потоке %s\n",chore, Thread.currentThread().getName());

    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      throw new RuntimeException("Задача " + chore + " была прервана." + e);
    }

    System.out.printf("обязанность %s выполнена\n", chore);
  }
}
