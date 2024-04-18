package faang.school.godbless.BJS2_5708;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
  private int startIndex;
  private int endIndex;
  @Override
  public void run() {
    for (int i = startIndex; i <= endIndex; i++) {
      System.out.println("Message: " + i);
    }
  }
}
