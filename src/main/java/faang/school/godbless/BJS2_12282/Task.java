package faang.school.godbless.BJS2_12282;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
  private String name;
  private String task;

  @Override
  public void run() {
    System.out.println("Задание " + task + " началось");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println(name + " завершил задачу " + task);
  }
}
