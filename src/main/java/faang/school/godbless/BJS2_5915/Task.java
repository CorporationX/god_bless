package faang.school.godbless.BJS2_5915;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task implements Runnable {
  private String name;
  private String task;

  @Override
  public void run() {
    System.out.println("Task begin");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      System.out.println("Task " + task + " failed: " + e);
      throw new RuntimeException(e);
    }
    System.out.println("Task end");
  }
}
